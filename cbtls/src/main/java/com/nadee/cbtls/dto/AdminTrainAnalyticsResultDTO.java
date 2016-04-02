package com.nadee.cbtls.dto;

import java.io.Serializable;
import java.util.List;

public class AdminTrainAnalyticsResultDTO implements Serializable {

  private static final long serialVersionUID = 1L;

  private String status;

  private List<String> labels;

  private List<ChartItemDTO> datasets;

  public String getStatus() {
    return status;
  }

  public void setStatus(String status) {
    this.status = status;
  }

  public List<String> getLabels() {
    return labels;
  }

  public void setLabels(List<String> labels) {
    this.labels = labels;
  }

  public List<ChartItemDTO> getDatasets() {
    return datasets;
  }

  public void setDatasets(List<ChartItemDTO> datasets) {
    this.datasets = datasets;
  }



}
