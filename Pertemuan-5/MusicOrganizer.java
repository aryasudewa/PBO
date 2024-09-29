import java.util.ArrayList;

public class MusicOrganizer {
    private ArrayList<Track> tracks;
    private MusicPlayer player;

    public MusicOrganizer() {
        tracks = new ArrayList<>();
        player = new MusicPlayer();
    }

    public void addTrack(String title, String artist) {
        tracks.add(new Track(title, artist));
        System.out.println("Added: " + title + " by " + artist);
    }

    public void listAllTracks() {
        if(tracks.isEmpty()) {
            System.out.println("No tracks in the collection.");
        }
        else {
            for(int i = 0; i < tracks.size(); i++) {
                System.out.println((i + 1) + ": " + tracks.get(i));
            }
        }
    }

    public void playTrack(int index) {
        if(index >= 0 && index < tracks.size()) {
            Track track = tracks.get(index);
            player.play(track);
        }
        else {
            System.out.println("Invalid track number.");
        }
    }

    public void stopPlaying() {
        player.stop();
    }

    public void removeTrack(int index) {
        if(index >= 0 && index < tracks.size()) {
            Track removed = tracks.remove(index);
            System.out.println("Removed: " + removed.getTitle() + " by " + removed.getArtist());
        }
        else {
            System.out.println("Invalid track number.");
        }
    }

    public int getNumberOfTracks() {
        return tracks.size();
    }

    public Track getTrack(int index) {
        if(index >= 0 && index < tracks.size()) {
            return tracks.get(index);
        }
        return null;
    }
}