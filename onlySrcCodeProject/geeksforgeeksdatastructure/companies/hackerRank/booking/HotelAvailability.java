package onlySrcCode.onlySrcCodeProject.geeksforgeeksdatastructure.companies.hackerRank.booking;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class HotelAvailability {
	private final static long  ONE_DAY = 24*60*60*1000;
	public static void main(String[] args) throws IOException, ParseException {
		// TODO Auto-generated method stub
		SimpleDateFormat format = new SimpleDateFormat("yyyy-mm-dd");

		BufferedReader brHotels = new BufferedReader(new FileReader("src/companies/hackerRank/booking/hotels.csv"));
		String line = null;
		Map<String, Integer> hotelsRoom = new HashMap<String, Integer>();
		
		while((line = brHotels.readLine())!= null){
			String[] hRoom = line.split(",");
			for (int i = 0; i < hRoom.length; i++) {
				hRoom[i]=hRoom[i].trim();
			}
			hotelsRoom.put(hRoom[0], Integer.parseInt(hRoom[1]));
		}
		
		
		BufferedReader brBook = new BufferedReader(new FileReader("src/companies/hackerRank/booking/bookings.csv"));
		Map<String, Map<Long, Integer>> hotelsBooking = new HashMap<String, Map<Long,Integer>>();
		
		//read from bookings.csv and save to 
		while((line = brBook.readLine())!= null){
			String[] hBook = line.split(",");
			for (int i = 0; i < hBook.length; i++) {
				hBook[i]=hBook[i].trim();
			}
			long startDate = getMilliSecondsFromDate(format,hBook[1]);
			long endDate = getMilliSecondsFromDate(format,hBook[2]);
			
			if(!hotelsBooking.containsKey(hBook[0])){
				hotelsBooking.put(hBook[0],new HashMap<Long, Integer>());
			}
			Map<Long, Integer> bookedDays = hotelsBooking.get(hBook[0]);
			while(startDate < endDate){
				if(!bookedDays.containsKey(startDate)){
					bookedDays.put(startDate, hotelsRoom.get(hBook[0]));
				}
				bookedDays.put(startDate, bookedDays.get(startDate)-1);
				startDate = startDate+ONE_DAY;
			}
		}
		
		Scanner scanner = new Scanner(System.in);
		long findStartDate = getMilliSecondsFromDate(format, scanner.next());
		long findEndDate = getMilliSecondsFromDate(format, scanner.next());
		
		for (Map.Entry<String, Integer> entry : hotelsRoom.entrySet()) {
			long temp = findStartDate;
			String hotel = entry.getKey();
			Map<Long, Integer> bookings = hotelsBooking.get(hotel);
			int min = hotelsRoom.get(hotel);
			while(temp<findEndDate && bookings != null){
				if(bookings.containsKey(temp)){
					int value = bookings.get(temp);
					if(value < min){
						min = value;
					}
				}
				temp += ONE_DAY;
			}
			System.out.println(hotel+" "+min);
		}
		
	}
	
	
	
	public static long getMilliSecondsFromDate(SimpleDateFormat format, String dateString) throws ParseException{
		long milliSecond = 0;
		Date date = format.parse(dateString);
		milliSecond = date.getTime();
		return milliSecond;
	}

	
	

}
