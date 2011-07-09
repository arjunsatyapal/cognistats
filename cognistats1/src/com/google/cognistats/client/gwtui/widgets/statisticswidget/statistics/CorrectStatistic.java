//package com.google.cognistats.client.gwtui.widgets.statisticswidget.statistics;
//
//import com.google.gwt.i18n.client.NumberFormat;
//
//public class CorrectStatistic extends Statistic {
//
//  public CorrectStatistic(double value) {
//    super(RowNamesEnum.CORRECT_ROW);
//
//    // For a correct ratio, i.e. 0.95
//    numberFormat = NumberFormat.getPercentFormat();
//    formatted = format(value);
//  }
//
//  protected String format(double value) {
//    return numberFormat.format(value);
//  }
//
//  public CorrectStatistic(boolean value) {
//    super(RowNamesEnum.CORRECT_ROW);
//    formatted = format(value);
//  }
//
//  protected String format(boolean value) {
//    if (value)
//      return "<span style=\"color: green;\">✓</span>";
//    else
//      return "<span style=\"color: red;\">×</span>";
//  }
//}
