public class MusicPlayer {
    private boolean isPlaying;

    public MusicPlayer() {
        this.isPlaying = false;
    }

    public void play(Track track) {
        if(isPlaying) {
            System.out.println("Another track is already playing. Please stop it first.");
        }
        else {
            System.out.println("Playing: " + track.getTitle() + " by " + track.getArtist());
            isPlaying = true;
            new Thread(() -> {
                try {
                    Thread.sleep(3000);
                }
                catch(InterruptedException e) {
                    e.printStackTrace();
                }
                finally {
                    stop();
                }
            }).start();
        }
    }

    public void stop() {
        if(isPlaying) {
            System.out.println("Music stopped.");
            isPlaying = false;
        }
        else {
            System.out.println("No track is currently playing.");
        }
    }
}