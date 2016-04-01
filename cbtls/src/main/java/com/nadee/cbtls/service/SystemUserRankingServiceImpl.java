package com.nadee.cbtls.service;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.nadee.cbtls.constant.ApplicationConstants;
import com.nadee.cbtls.constant.GeneralEnumConstants.YesNoStatus;
import com.nadee.cbtls.dao.CommonDAO;
import com.nadee.cbtls.dao.SystemUserRankingDAO;
import com.nadee.cbtls.dto.SystemUserRankingsDTO;
import com.nadee.cbtls.model.SystemUser;
import com.nadee.cbtls.model.SystemUserMobileDevice;
import com.nadee.cbtls.model.SystemUserRankings;

@Service("systemUserRankingService")
@Transactional(propagation = Propagation.SUPPORTS, readOnly = false)
public class SystemUserRankingServiceImpl implements SystemUserRankingService {

	@Autowired
	private SystemUserRankingDAO systemUserRankingDAO;
	

	  @Autowired
	  private SystemUserService systemUserService;
	
	@Autowired
	private CommonDAO commonDAO;

	@Override
	public Map<String, Object> saveRanking(SystemUserRankingsDTO dto) throws Exception {
	  Map<String, Object> resultMap = new HashMap<String, Object>();
      
      SystemUser updatedUser = null;

      if (StringUtils.isNotEmpty(dto.getSystemUserMobileDevice())) {
        SystemUserMobileDevice systemUserMobileDevice =
            systemUserService.getSystemUserMobileDeviceByUniqueId(dto.getSystemUserMobileDevice());
        if (systemUserMobileDevice == null) {
          systemUserMobileDevice =
              systemUserService.createMobileUser(dto.getSystemUserMobileDevice(), null);
        }
        updatedUser = systemUserMobileDevice.getSystemUser();
        resultMap.put(ApplicationConstants.USER_TYPE, ApplicationConstants.MOBILE_USER);
        resultMap.put(ApplicationConstants.USER_ID,
            systemUserMobileDevice.getMobileDevice().getUniqueMobileDeviceNumber());
      } else {
        if (!(dto.getUpdatedUser() == 0)) {
          updatedUser = commonDAO.getEntityById(SystemUser.class, dto.getUpdatedUser());
        }
        if (updatedUser == null) {
          updatedUser = systemUserService.createWebUser(null, null);
        }
        resultMap.put(ApplicationConstants.USER_TYPE, ApplicationConstants.WEB_USER);
        resultMap.put(ApplicationConstants.USER_ID, updatedUser.getUserId());
      }
	  
		SystemUserRankings systemUserRankings=new SystemUserRankings(dto);
		systemUserRankings.setActiveStatus(YesNoStatus.YES);
		systemUserRankings.setRankedDate(Calendar.getInstance().getTime());
		SystemUser systemUser=commonDAO.getEntityById(SystemUser.class, dto.getSystemUserId());
		if(systemUser.getSystemUserRankings()==null){
			systemUser.setSystemUserRankings(new ArrayList<SystemUserRankings>());
		}
		systemUser.getSystemUserRankings().add(systemUserRankings);
		List<SystemUserRankingsDTO> dtos=convertToDTOList(systemUser.getSystemUserRankings());
		float averageRate=calculateAverageSystemUserRanking(dtos);
		systemUserRankings.setAverageRate(averageRate);
		systemUserRankings.setSystemUser(systemUser);
		systemUser.setAverageRanking(averageRate);
		
		commonDAO.saveOrUpdateEntity(systemUser);
		
		resultMap.put(ApplicationConstants.RESULT, ApplicationConstants.SUCCESS);
		
		return resultMap;
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
