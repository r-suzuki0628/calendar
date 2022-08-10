package com.example.calendarproject.Models;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.time.temporal.TemporalAdjusters;
import java.util.ArrayList;

import org.springframework.stereotype.Service;

@Service
public class GetDayModel {
	
	//今日の年と月と日を生成
	public ArrayList<Integer> CurrentMonthAndDays() {
		LocalDateTime nowDateTime = LocalDateTime.now();
		LocalDateTime firstDayTime = nowDateTime.with(TemporalAdjusters.firstDayOfMonth());
		LocalDateTime lastDayTime = nowDateTime.with(TemporalAdjusters.lastDayOfMonth());
		return CurrentDayCalendar(nowDateTime, firstDayTime, lastDayTime);
	}
	
	public String CurrentYearAndMonth() {
		LocalDateTime nowDateTime = LocalDateTime.now();
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("uuuu/MM");
		String YearAndMonth = nowDateTime.format(formatter);
		return YearAndMonth;
	}
	
	//今日の年と月をもとに日付を生成
	private static ArrayList<Integer> CurrentDayCalendar(LocalDateTime nowDateTime, LocalDateTime firstDayTime, LocalDateTime lastDayTime) {
		String weeksJp[] = { "日", "月", "火", "水", "木", "金", "土" };
		ArrayList<Integer> firstDayToLastDay = new ArrayList<>();
		//今月の初日
		int days = firstDayTime.getDayOfMonth();
		//今月の末日
		int lastdays = lastDayTime.getDayOfMonth();
		//初日の曜日生成
		DateTimeFormatter formatterJp = DateTimeFormatter.ofPattern("E");
		String firstDayWeekJp = firstDayTime.format(formatterJp);
		String lastDayWeekJp = lastDayTime.format(formatterJp);
		//今月分の1日前に前月分の日にちを生成
		for (int i = 0; i <= 6; i++) {
			if (weeksJp[i].equals(firstDayWeekJp)) {
				for (int e = 1; e <= i; e++) {
					LocalDateTime lastmonthdaytime = firstDayTime.minusDays(e);
					int lastmonthday = lastmonthdaytime.getDayOfMonth();
					firstDayToLastDay.add(lastmonthday);
				}
			}
		}
		//今月の初日～末日まで生成		
		for(int i = 1; i <= lastdays; i++) {
			firstDayToLastDay.add(i);
		};
		//今月分の末日後に来月分の日にちを生成
		for (int i = 0; i <= 6; i++) {
			if (weeksJp[i].equals(lastDayWeekJp)) {
				for (int e = 1; e <= 6-i; e++) {
					LocalDateTime lastmonthdaytime = lastDayTime.plusDays(e);
					int nextmonthday = lastmonthdaytime.getDayOfMonth();
					firstDayToLastDay.add(nextmonthday);
				}
			}
		}
		return firstDayToLastDay;	
	}
	
};

