package com.nadee.cbtls.service;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.nadee.cbtls.constant.GeneralEnumConstants.YesNoStatus;
import com.nadee.cbtls.dao.CommonDAO;
import com.nadee.cbtls.dao.SystemUserRankingDAO;
import com.nadee.cbtls.dto.SystemUserRankingsDTO;
import com.nadee.cbtls.model.SystemUser;
import com.nadee.cbtls.model.SystemUserRankings;

@Service("systemUserRankingService")
@Transactional(propagation = Propagation.SUPPORTS, readOnly = false)
public class SystemUserRankingServiceImpl implements SystemUserRankingService {

	@Autowired
	private SystemUserRankingDAO systemUserRankingDAO;
	
	@Autowired
	private CommonDAO commonDAO;

	@Override
	public String saveRanking(SystemUserRankingsDTO systemUserRankingsDTO) {
		SystemUserRankings systemUserRankings=new SystemUserRankings(systemUserRankingsDTO);
		systemUserRankings.setActiveStatus(YesNoStatus.YES);
		systemUserRankings.setRankedDate(Calendar.getInstance().getTime());
		SystemUser systemUser=commonDAO.getEntityById(SystemUser.class, systemUserRankingsDTO.getSystemUserId());
		if(systemUser.getSystemUserRankings()==null){
			systemUser.setSystemUserRankings(new ArrayList<SystemUserRankings>());
		}
		systemUser.getSystemUserRankings().add(systemUserRankings);
		List<SystemUserRankingsDTO> dtos=convertToDTOList(systemUser.getSystemUserRankings());
		float averageRate=calculateAverageSystemUserRanking(dtos);
		systemUserRankings.setAverageRate(averageRate);
		systemUserRankings.setSystemUser(systemUser);
		systemUser.setAverageRanking(averageRate);
		return commonDAO.saveOrUpdateEntity(systemUser);
	}

	private List<SystemUserRankingsDTO> convertToDTOList(List<SystemUserRankings> systemUserRankingList) {
		List<SystemUserRankingsDTO> dtos=new ArrayList<SystemUserRankingsDTO>();
		if(!(systemUserRankingList==null)){
			for (SystemUserRankings systemUserRankings : systemUserRankingList) {
				dtos.add(new SystemUserRankingsDTO(systemUserRankings));
			}
		}
		return dtos;
	}

	@Override
	public String deleteRanking(long id) {
		return commonDAO.deleteEntity(id);
	}
	
	private float calculateAverageSystemUserRanking(List<SystemUserRankingsDTO> list) {
		if (!(list == null)) {
			float averageranking = 0;
			int countRank1 = 0;
			int countRank2 = 0;
			int countRank3 = 0;
			int countRank4 = 0;
			int countRank5 = 0;
			
			for (SystemUserRankingsDTO systemUserRankings : list) {
				switch (systemUserRankings.getRanking()) {
				case 1:
					countRank1++;
					break;
				case 2:
					countRank2++;
					break;
				case 3:
					countRank3++;
					break;
				case 4:
					countRank4++;
					break;
				case 5:
					countRank5++;
					break;
				default:
					break;
				}
			}
			averageranking=(5*countRank5 + 4*countRank4 + 3*countRank3 + 2*countRank2 + 1*countRank1)
					/(countRank5+countRank4+countRank3+countRank2+countRank1);
			
			return averageranking;
		}
		return 0;
	}
	
	@Override
	public float getAverageSystemUserRanking(long userId) {
		SystemUser systemUser=commonDAO.getEntityById(SystemUser.class, userId);
		if(!(systemUser==null)){
			return systemUser.getAverageRanking();
		}
		return 0;
	}

	@Override
	public List<SystemUserRankingsDTO> getAllSystemUserRankings(long userId) {
		List<SystemUserRankings> systemUserRankingList=  systemUserRankingDAO.getSystemUserRankingsByUserId(userId);
		return convertToDTOList(systemUserRankingList);
	}

}
