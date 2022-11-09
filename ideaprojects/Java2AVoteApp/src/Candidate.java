import javax.swing.*;

public class Candidate {
    private String candidateName;
    private int numberOfVotes;
    private ImageIcon candidateImage;

    public String getCandidateName() {
        return this.candidateName;
    }

    public void setCandidateName(String candidateName) {
        this.candidateName = candidateName;
    }

    public int getNumberOfVotes() {
        return this.numberOfVotes;
    }

    public void setNumberOfVotes(int numberOfVotes) {
        this.numberOfVotes = numberOfVotes;
    }

    public ImageIcon getCandidateImage() {
        return this.candidateImage;
    }

    public void setCandidateImage(ImageIcon candidateImage) {
        this.candidateImage = candidateImage;
    }

    // setting the Constructor for Candidate class
    Candidate(String CandidateName, ImageIcon CandidateImage) {
        setCandidateName(CandidateName);
        setCandidateImage(CandidateImage);
    }
}