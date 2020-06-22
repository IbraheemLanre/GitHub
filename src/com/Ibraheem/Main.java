package com.Ibraheem;

import java.util.*;

public class Main {
    private static Scanner scanner = new Scanner(System.in);
    private static ArrayList<Album> albums = new ArrayList<Album>();

    public static void main(String[] args) {

        //Create first album
        Album album = new Album("Talk", "Khalid");
        album.addNewSong("Talk", 3.43);
        album.addNewSong("Eleven", 3.52);
        album.addNewSong("Better", 4.11);
        album.addNewSong("Saturday Nights", 3.61);
        albums.add(album); // add first album to the album list

        //Create another album
        album = new Album("KIRK", "DaBaby");
        album.addNewSong("Intro", 3.11);
        album.addNewSong("Suge", 4.10);
        album.addNewSong("BOP", 3.56);
        album.addNewSong("RAW SHIT", 3.71);
        albums.add(album); // add the second album to the album list

        LinkedList<Song> playList = new LinkedList<Song>();
        albums.get(0).addToPlayList("Talk", playList);
        albums.get(0).addToPlayList("Better", playList);
        albums.get(0).addToPlayList("Boo'd Up", playList); //Does not exist
        albums.get(0).addToPlayList(2, playList); //Using the track numbers to add songs

        albums.get(1).addToPlayList(1, playList);
        albums.get(1).addToPlayList(2, playList);
        albums.get(1).addToPlayList(18, playList); // There is no track 18

        play(playList);

    }

    private static void play(LinkedList<Song> playList) {
        Scanner scanner = new Scanner(System.in);
        boolean appMenu = false;
        boolean forward = true;

        ListIterator<Song> listIterator = playList.listIterator();
        if (playList.size() == 0) {
            System.out.println("No song in playlist");
        }else {
            System.out.println("Now playing " + listIterator.next().toString());
            printAppMenuOption();
        }

        while(!appMenu) {
            int selection = scanner.nextInt();
            scanner.nextLine();

            switch (selection) {
                case 0:
                    System.out.println("Playlist Ready");
                    appMenu = true;
                    break;
                case 1:
                    if(!forward) {
                        if(listIterator.hasNext()) {
                            listIterator.next();
                        }
                        forward = true;
                    }
                    if (listIterator.hasNext()) {
                        System.out.println("Now playing " + listIterator.next().toString());
                    } else {
                        System.out.println("We've reached the end of the playlist");
                        forward = false;
                    }
                    break;
                case 2:
                    if (forward) {
                        if (listIterator.hasPrevious()) {
                            listIterator.previous();
                        }
                        forward = false;
                    }
                    if (listIterator.hasPrevious()) {
                        System.out.println("Now playing " + listIterator.previous().toString());
                    }else {
                        System.out.println("We're at the start of the playlist");
                        forward = true;
                    }
                    break;
                case 3:
                    if (forward) {
                        if (listIterator.hasPrevious()) {
                            System.out.println("Now replaying " + listIterator.previous().toString());
                            forward = false;
                        }else {
                            System.out.println("We're at the start of the list");
                        }
                    }else {
                        if (listIterator.hasNext()) {
                            System.out.println("Now replaying " + listIterator.next().toString());
                            forward = true;
                        }else {
                            System.out.println("We've reached the end of the list");
                        }
                    }
                    break;
                case 4:
                    printList(playList);
                    break;
                case 5:
                    printAppMenuOption();
                    break;
                case 6:
                    if (playList.size() > 0) {
                        listIterator.remove();
                        if (listIterator.hasNext()) {
                            System.out.println("Now playing " + listIterator.next());
                        }else if(listIterator.hasPrevious()) {
                            System.out.println("Now playing " + listIterator.previous());
                        }
                    }
                    break;
            }
        }
    }

    private static void printAppMenuOption() {
        System.out.println("Available options:\npress");
        System.out.println("0 - to quit\n" +
                "1 - to play next song\n" +
                "2 - to play the previous song\n" +
                "3 - to replay the current song\n" +
                "4 - to list available songs in the playlist\n" +
                "5 - to print available options.\n" +
                "6 - to delete current song from the playlist");
    }

    private static void printList(LinkedList<Song> playList) {
        Iterator<Song> iterator = playList.iterator();
        System.out.println("===================================");
        while(iterator.hasNext()) {
            System.out.println(iterator.next().toString());
        }
        System.out.println("===================================");
    }
}
