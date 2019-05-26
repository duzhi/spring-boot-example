package com.daimabaikeuf;

import java.time.LocalDateTime;
import java.time.ZoneOffset;
import java.time.format.DateTimeFormatter;

import org.junit.Test;

public class CommonTest {

	@Test
	public void ss() {
		
		LocalDateTime localDateTime  = LocalDateTime.now();

        System.out.println(localDateTime.format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss.SSS")));


        localDateTime = LocalDateTime.parse("2017-01-01 07:59:59", DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss"));
        
        System.out.println(localDateTime.format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss")));
        
        System.out.println(localDateTime.toInstant(ZoneOffset.ofHours(8)).getEpochSecond());
        
        localDateTime = LocalDateTime.parse("2017-01-01 08:00:00", DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss"));
        
        System.out.println(localDateTime.format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss")));
        
        System.out.println(localDateTime.toInstant(ZoneOffset.ofHours(8)).getEpochSecond());
        
        
	}
	
}
