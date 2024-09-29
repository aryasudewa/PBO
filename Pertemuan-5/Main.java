public class Main {
    public static void main(String[] args) {
        MusicOrganizer organizer = new MusicOrganizer();
        
        organizer.addTrack("Song One", "Artist A");
        organizer.addTrack("Song Two", "Artist B");
        organizer.addTrack("Song Three", "Artist C");

        System.out.println("\nAll Tracks:");
        organizer.listAllTracks();

        System.out.println("\nPlaying Track 1:");
        organizer.playTrack(0);

        try {
            Thread.sleep(4000);
        }
        catch(InterruptedException e) {
            e.printStackTrace();
        }

        organizer.stopPlaying();

        System.out.println("\nRemoving Track 2:");
        organizer.removeTrack(1);

        System.out.println("\nAll Tracks After Removal:");
        organizer.listAllTracks();
    }
}