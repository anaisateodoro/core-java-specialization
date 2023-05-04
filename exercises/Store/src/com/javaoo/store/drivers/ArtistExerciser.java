package com.javaoo.store.drivers;

import java.util.Arrays;
import java.util.SortedSet;
import java.util.TreeSet;

import com.javaoo.store.Artist;

import static java.lang.System.out;

public class ArtistExerciser {
	
	public static void printMemberInstruments(Artist artist, String memberName) {
		out.printf("%s band member %s plays: %n", artist.getName(), memberName);
		for (String instrument: artist.getInstruments(memberName)) {
			out.println("\t" + instrument);
		}
	}

	public static void main(String[] args) {
		Artist hotplate = new Artist("HotPlate"); 
		
		SortedSet<String> instruments1 = new TreeSet<>();
		instruments1.addAll(Arrays.asList(new String[] {"Piano", "Clarinet", "Hurdy Gurdy", "Tuba"}));
		hotplate.addMember("Tom", instruments1);
		
		SortedSet<String> instruments2 = new TreeSet<>();
		instruments2.addAll(Arrays.asList(new String[] {"Piano", "Drums"}));
		hotplate.addMember("Steve", instruments2);
		
		printMemberInstruments(hotplate, "Tom");
		printMemberInstruments(hotplate, "Steve");
	}
}
