package com.nadee.cbtls.dao;

import java.util.List;

import com.nadee.cbtls.constant.GeneralEnumConstants.YesNoStatus;
import com.nadee.cbtls.dto.AdminSearchDTO;
import com.nadee.cbtls.model.TrainScheduleTurn;
import com.nadee.cbtls.model.TrainStationScheduleTurn;

public interface TrainScheduleTurnDAO {

  public long countActiveTrainScheduleTurns() throws Exception;

  public List<TrainScheduleTurn> listAllTrainScheduleTurns(YesNoStatus yesNoStatus)
      throws Exception;

  public List<TrainStationScheduleTurn> fetchTrainScheduleTurns(AdminSearchDTO adminSearchDTO)
      throws Exception;

  public List<TrainStationScheduleTurn> fetchTrainScheduleTurnsById(AdminSearchDTO adminSearchDTO)
      throws Exception;

}
