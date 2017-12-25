package companies.hackerRank.booking;

import java.io.InputStreamReader;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Date;
import java.util.Scanner;

public class CheckInCheckOut {

	public static void main(String[] args) throws ParseException {
		// TODO Auto-generated method stub
		SimpleDateFormat format = new SimpleDateFormat("yyyy-mm-dd");
		//Scanner scanner = new Scanner(new InputStreamReader(new ))
		Scanner scanner = new Scanner(System.in);
		int n = scanner.nextInt();
		long[] checkIn = new long[n];
		long[] checkOut = new long[n];
		for (int i = 0; i < n; i++) {
			checkIn[i] = getMilliSecondsFromDate(format, scanner.next());
			checkOut[i] = getMilliSecondsFromDate(format, scanner.next());
		}
		
		System.out.println(findMinRequired(checkIn, checkOut));
	}
	
	public static long findMinRequired(long[] checkIn, long[] checkOut){
		Arrays.sort(checkIn);
		Arrays.sort(checkOut);
		int count = 0;
		int len = checkIn.length;
		int max = 0;
		int i = 0, j = 0;
		while(i < len || j < len){
			if(i<len && checkIn[i] < checkOut[j]){
				count++;
				i++;
			}else{
				count--;
				j++;
			}
			if(count > max){
				max = count;
			}
		}
		
		return max;
	}
	
	public static long getMilliSecondsFromDate(SimpleDateFormat format, String dateString) throws ParseException{
		long milliSecond = 0;
		Date date = format.parse(dateString);
		milliSecond = date.getTime();
		return milliSecond;
	}

}
