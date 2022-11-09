import javax.swing.*;

public class Candidate {
    private int candidateVotes;
    private String candidateName;
    private ImageIcon candidateImage;

    public String getCandidateName() {
        return candidateName;
    }

    public void setCandidateName(String candidateName) {
        this.candidateName = candidateName;
    }

    public ImageIcon getCandidateImage() {
        return candidateImage;
    }

    public void setCandidateImage(ImageIcon candidateImage) {
        this.candidateImage = candidateImage;
    }

    public int getCandidateVotes() {
        return candidateVotes;
    }

    public void setCandidateVotes(int candidateVotes) {
        this.candidateVotes = candidateVotes;
    }

    Candidate(String candidateName, ImageIcon candidateImage) {
        setCandidateName(candidateName);
        setCandidateImage(candidateImage);
    }
}
