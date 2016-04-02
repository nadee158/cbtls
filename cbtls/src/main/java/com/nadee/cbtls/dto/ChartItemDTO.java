package com.nadee.cbtls.dto;

import java.io.Serializable;
import java.util.List;

public class ChartItemDTO implements Serializable {

  private static final long serialVersionUID = 1L;

  private String label;

  private List<Long> data;

  private String fillColor = "rgba(220,220,220,0.2)";
  private String strokeColor = "rgba(220,220,220,1)";
  private String pointColor = "rgba(220,220,220,1)";
  private String pointStrokeColor = "#fff";
  private String pointHighlightFill = "#fff";
  private String pointHighlightStroke = "rgba(220,220,220,1)";

  public String getLabel() {
    return label;
  }

  public void setLabel(String label) {
    this.label = label;
  }


  public List<Long> getData() {
    return data;
  }

  public void setData(List<Long> data) {
    this.data = data;
  }

  public ChartItemDTO(String label, List<Long> data) {
    super();
    this.label = label;
    this.data = data;
  }



  public ChartItemDTO() {
    super();
  }

  public String getFillColor() {
    return fillColor;
  }

  public void setFillColor(String fillColor) {
    this.fillColor = fillColor;
  }

  public String getStrokeColor() {
    return strokeColor;
  }

  public void setStrokeColor(String strokeColor) {
    this.strokeColor = strokeColor;
  }

  public String getPointColor() {
    return pointColor;
  }

  public void setPointColor(String pointColor) {
    this.pointColor = pointColor;
  }

  public String getPointStrokeColor() {
    return pointStrokeColor;
  }

  public void setPointStrokeColor(String pointStrokeColor) {
    this.pointStrokeColor = pointStrokeColor;
  }

  public String getPointHighlightFill() {
    return pointHighlightFill;
  }

  public void setPointHighlightFill(String pointHighlightFill) {
    this.pointHighlightFill = pointHighlightFill;
  }

  public String getPointHighlightStroke() {
    return pointHighlightStroke;
  }

  public void setPointHighlightStroke(String pointHighlightStroke) {
    this.pointHighlightStroke = pointHighlightStroke;
  }



}
