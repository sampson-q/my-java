package com.ATUSRCVotingApp;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Objects;

public class SRCVotingApp {
    private JPanel framePanel;
    private JPanel landingPanel;
    private JCheckBox presCheckBox;
    private JCheckBox secCheckBox;
    private JCheckBox tresCheckBox;
    private JButton toCandidatesPage;
    private JPanel presCandidatesPanel;
    private JCheckBox presCandidate0;
    private JCheckBox presCandidate1;
    private JButton toConfirmPresVote;
    private JButton toLandingPage;
    private JLabel presCandidate0Img;
    private JLabel presCandidate1Img;
    private JLabel presCandidate0Name;
    private JLabel presCandidate1Name;
    private JPanel confirmVotePanel;
    private JButton cancelConfirm;
    private JButton voteButton;
    private JLabel finalConfirmCandidateName;
    private JLabel finalConfirmPosition;
    private JLabel confirmCandidateImage;

    private String candidateName;
    private JCheckBox voteToWho;

    private static int presCandidate0Votes;
    private static int presCandidate1Votes;

    private JCheckBox voteType;
    private JPanel nextPanel;

    void disableCheckBoxes(JCheckBox...jCheckBoxes) {
        for (JCheckBox checkBox : jCheckBoxes) {
            checkBox.setEnabled(false);
        }
    }

    void enableCheckBoxes(JCheckBox...jCheckBoxes) {
        for (JCheckBox checkBox : jCheckBoxes) {
            checkBox.setEnabled(true);
            checkBox.setSelected(false);
        }
    }

    void enableLabels(JLabel...jLabels) {
        for (JLabel jLabel : jLabels) {
            jLabel.setEnabled(true);
        }
    }

    void disableButtons(JButton...jButtons) {
        for (JButton button : jButtons) {
            button.setEnabled(false);
        }
    }

    void swapPanels(JPanel panel0, JPanel panel1) {
        panel0.setVisible(false);
        panel1.setVisible(true);
    }

    void disableCandidates(JLabel candidateName, JCheckBox candidateCheck) {
        disableCheckBoxes(candidateCheck);
        candidateName.setEnabled(false);
    }

    void alertConfirmVote(JCheckBox voteType) {
        JFrame confirmFrame = new JFrame();

        if (Objects.equals(voteType.getText(), "SRC President")) {
            confirmFrame.setTitle("Confirm SRC Presidential Vote");
        }

        finalConfirmCandidateName.setText(candidateName);
        finalConfirmPosition.setText(voteType.getText());

        confirmFrame.setContentPane(confirmVotePanel);
        confirmFrame.setLocationRelativeTo(null);
        confirmFrame.setSize(400, 200);
        confirmFrame.setVisible(true);
    }

    public SRCVotingApp() {

        presCandidatesPanel.setVisible(false);
        confirmVotePanel.setVisible(false);

        // action listener for landing page
        ActionListener landingPageListener = voteTypeListener -> {
            if (presCheckBox.isSelected()) {
                disableCheckBoxes(secCheckBox, tresCheckBox);
                nextPanel = presCandidatesPanel;
                voteType = presCheckBox;
            }

            else if (secCheckBox.isSelected()) { disableCheckBoxes(presCheckBox, tresCheckBox); }
            else if (tresCheckBox.isSelected()) { disableCheckBoxes(presCheckBox, secCheckBox); }
            else { enableCheckBoxes(presCheckBox, tresCheckBox, secCheckBox); }

            toCandidatesPage.setEnabled(presCheckBox.isSelected() || secCheckBox.isSelected() || tresCheckBox.isSelected());

            // adding action listener to next button in homepage
            toCandidatesPage.addActionListener(candidatesBtn -> {
                swapPanels(landingPanel, nextPanel);
            });
        };

        // adding landing page action listeners to the checkboxes on the landing page
        presCheckBox.addActionListener(landingPageListener);
        secCheckBox.addActionListener(landingPageListener);
        tresCheckBox.addActionListener(landingPageListener);

        // action listener for presidential voting page
        ActionListener presidentialPageListener = presVoteListener -> {
            if (presCandidate0.isSelected()) {
                disableCandidates(presCandidate1Name, presCandidate1);
                candidateName = presCandidate0Name.getText();
                confirmCandidateImage.setIcon(new ImageIcon("C:\\Users\\Hash\\IdeaProjects\\SRCVotingApp\\src\\images\\pres0Image.PNG"));
                voteToWho = presCandidate0;
            }
            else if (presCandidate1.isSelected()) {
                disableCandidates(presCandidate0Name, presCandidate0);
                candidateName = presCandidate1Name.getText();
            }
            else {
                enableCheckBoxes(presCandidate0, presCandidate1);
                enableLabels(presCandidate0Name, presCandidate1Name);
                disableButtons(toConfirmPresVote);
            }

            toConfirmPresVote.setEnabled(presCandidate0.isSelected() || presCandidate1.isSelected());

            // adding action listener to confirm presidential vote button
            toConfirmPresVote.addActionListener(confirmPresVote -> {
                confirmVotePanel.setVisible(true);
                alertConfirmVote(voteType);
            });
        };

        presCandidate0.addActionListener(presidentialPageListener);
        presCandidate1.addActionListener(presidentialPageListener);

        // adding action listener to the back button in presidential candidates page
        toLandingPage.addActionListener(backToLandingPageAction -> {
            swapPanels(presCandidatesPanel, landingPanel); // display landing pane over presidential candidates pane
            enableCheckBoxes(presCheckBox, secCheckBox, tresCheckBox); // enable all the checkboxes and deselect them
            disableButtons(toCandidatesPage); // disable the next button again
        });

        voteButton.addActionListener(voteAdd -> {
            if (voteToWho == presCandidate0) {
                presCandidate0Votes++;
                toConfirmPresVote.setEnabled(true);

            } else if (voteToWho == presCandidate1) {
                presCandidate1Votes++;
                toConfirmPresVote.setEnabled(true);
            } else {
                enableCheckBoxes(presCandidate0, presCandidate1);
                enableLabels(presCandidate0Name, presCandidate1Name);
                disableButtons(toConfirmPresVote);
            }
        });
    }

    public static void main(String[] args) {
        JFrame frame = new JFrame("ATU SRC Voting App");
        frame.setContentPane(new SRCVotingApp().framePanel);
        frame.setSize(700, 300);
        frame.setLocationRelativeTo(null);
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        frame.setVisible(true);
    }
}