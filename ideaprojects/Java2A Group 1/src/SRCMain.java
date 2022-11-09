import javax.swing.*;
import java.awt.event.*;
import java.util.Arrays;
import java.util.Objects;


public class SRCMain {

    // setting presidential candidates
    public static Candidate presidentCandidate0 = new Candidate("Julia Hodgson", new ImageIcon("src/images/julia.jpg"));
    public static Candidate presidentCandidate1 = new Candidate("Zulkanian Jamal", new ImageIcon("src/images/jamal.jpeg"));

    // setting secretarial candidates
    public static Candidate secretaryCandidate0 = new Candidate("Owusu Emmanuel", new ImageIcon("src/images/null-user.png"));
    public static Candidate secretaryCandidate1 = new Candidate("Ndzinu George Kwaku", new ImageIcon("src/images/george.jpg"));
    public static Candidate secretaryCandidate2 = new Candidate("Addae-Abrokwa Victor Nana", new ImageIcon("src/images/nana.jpg"));

    // setting treasurer candidates
    public static Candidate treasurerCandidate0 = new Candidate("Ankrah Osborn Nii Ayi", new ImageIcon("src/images/null-user.png"));
    public static Candidate treasurerCandidate1 = new Candidate("Amissah Constantine Van-Dyck", new ImageIcon("src/images/null-user.png"));

    // setting portfolios
    public static Portfolio presidentialOffice = new Portfolio("SRC President"); // setting presidential office
    public static Portfolio secretarialOffice = new Portfolio("SRC Secretary"); // secretarial office
    public static Portfolio treasurerOffice = new Portfolio("SRC Treasurer"); // treasurer office

    private JPanel verifyVoterIDPane;
    private JTextField voterID;
    private JButton confirmVoterID;
    private JLabel confirmVoterIDErrorMessage;
    private JPanel mainPane;
    private JPanel portfolioPane;
    private JCheckBox SRCTreasurerCheckBox, SRCSecretaryCheckBox, SRCPresidentCheckBox;
    private JButton backNavButton, nextNavButton;
    private JPanel candidatePane;
    private JLabel candidate0Icon, candidate0Name;
    private JCheckBox candidate0Box;
    private JLabel candidate1Icon, candidate1Name;
    private JCheckBox candidate1Box, candidate2Box;
    private JLabel candidate2Icon, candidate2Name;
    private JPanel confirmVotePane;
    private JLabel confirmCandidateImage, candidateOfficeConfirm, candidateNameConfirm;
    private JButton voteButton, cancelButton;
    private JPanel voteAlertPane;
    private JButton OKButton;
    private JLabel alertVoteImage, alertCandidName, alertPortfolioName;
    private JPanel viewAddedPortfolioPane;
    private JCheckBox newPort2, newPort1, newPort0;
    private JButton closeViewAddedPortfolioPane;
    private JPanel voteResultsPane;
    private JLabel can0VoteIcon, can0VoteName, can1VoteIcon, can2VoteIcon, can3VoteIcon, can4VoteIcon, can5VoteIcon, can1VoteName;
    private JLabel can2VoteName, can3VoteName, can5VoteName, can4VoteName,can0VoteCount, can1VoteCount, can2VoteCount, can3VoteCount;
    private JLabel can4VoteCount,   can5VoteCount,   can6VoteCount,  can6VoteName,  can6VoteIcon;
    private JButton closeVotesPane;
    private JPanel addNewPortfolioPane;
    private JTextField portfolioName;
    private JButton addPortfolioButton;
    private JLabel errorLabel;
    private JButton closeAddPortfolioPane;
    private JPanel helpPane;
    private JButton closeHelpPane;
    private JLabel newPort0Label, newPort1Label, newPort2Label, newPortMessageLabel;

    static JFrame mainFrame;
    JPanel currentPane;
    JCheckBox selectedOffice, selectedCandid;
    String selectedCandidName, voter_id;
    ImageIcon candidConfirmIcon;
    JFrame confirmVoteFrame, voteAlertFrame;
    int presidentialVoteCounter = -1, secretarialVoteCounter = -1, treasurerVoteCounter = -1;

    // method to check if a user can vote
    static boolean canVote(String voterID, String[]...arrays) {
        String[] temp = new String[arrays.length]; // temp array with the size of the number of variable parameters

        for (int i = 0; i < arrays.length; ++i) {
            if (Arrays.asList(arrays[i]).contains(voterID)) { // if any of the arrays passed to the function contains the voterID
                temp[i] = "true"; // insert "true" to the position of the said array in temp
            } else { // else
                temp[i] = "false"; // insert false
            }
        }

        // for loop to check if any of the elements in the temp array is false
        for (String tempElements : temp) { // for tempElements in temp
            if (Objects.equals(tempElements, "false")) { // if tempElement equals "false"
                return true; // return true... which means that the user can vote
            }
        }

        return false; // by default, this method returns false
    }

    // method to help us set various portfolios
    void addPortfolio(JCheckBox jCheckBox, Portfolio portfolio) {
        jCheckBox.setText(portfolio.getPortfolioName()); // set the text to the portfolio's name
    }

    // method to help us toggle the visibility of labels
    void showLabels(int state, JLabel...jLabels) {
        for (JLabel jLabel : jLabels) { // for all the labels passed to this method,
            jLabel.setVisible(state != 0); // set its visibility to (state != 0)
        }
    }

    // add new portfolio function
    void addPortfolio(JCheckBox jCheckbox, JLabel jLabel, Portfolio portfolio) {
        showLabels(1, jLabel); // show the label... because by default, all of those labels are hidden
        showCheckBoxes(1, jCheckbox); // show the checkbox... because by default, all of them are hidden
        jLabel.setText(portfolio.getPortfolioName()); // set the text of the portfolio's label to the portfolio's name
    }

    // method to help us switch between various panels
    void swapPanes(JPanel panel0, JPanel...otherPanels) {
        panel0.setVisible(true); // set the first parameter's visibility to true

        // for the other parameters,
        for (JPanel panel : otherPanels) {
            if (panel != panel0) // if the panel listed is among the other panels to be hidden, ignore it
                panel.setVisible(false); // set their visibility to false
        }
    }

    // method to helps us to toggle buttons to disable or enable
    void enableButtons(int state, JButton...jButtons) {
        for (JButton jButton: jButtons) { // for all the buttons passed
            jButton.setEnabled(state != 0); // set their visibility to (state != 0)
        }
    }

    // method to toggle checkboxes to enable or disable
    void enableCheckBoxes(int state, JCheckBox...jCheckBoxes) {
        for (JCheckBox jCheckBox : jCheckBoxes) {
            jCheckBox.setEnabled(state != 0);
        }
    }

    // method to deselect checkboxes to selected or deselected
    void deselectCheckBoxes(JCheckBox... jCheckBoxes) {
        for(JCheckBox checkBox : jCheckBoxes) { // for all the checkboxes,
            checkBox.setSelected(false); // set their selected state to false
        }
    }

    // method to disable or enable labels
    void enableLabels(int state, JLabel...jLabels) {
        for (JLabel jLabel : jLabels) { // for all the labels
            jLabel.setEnabled(state != 0); // set their enabled state to (state != 0)
        }
    }

    // method to remove the text and icons of labels
    void clearLabels(JLabel...jLabels) {
        for (JLabel jLabel : jLabels) { // for all the labels provided,
            jLabel.setIcon(null); // set their icons to null
            jLabel.setText(""); // set their text to empty
        }
    }

    // method to show or hide checkboxes
    void showCheckBoxes(int state, JCheckBox...jCheckBoxes) {
        for (JCheckBox checkBox : jCheckBoxes) { // for all the checkboxes
            checkBox.setVisible(state != 0); // set their visibilities to (state != 0);
        }
    }

    // set up candidate details for vote
    void setCandidatesForVote(Candidate candidate0, Candidate candidate1, Candidate...candidates) {
        // setting the details of first candidate
        candidate0Icon.setIcon(candidate0.getCandidateImage()); // setting the icon of first candidate
        candidate0Name.setText(candidate0.getCandidateName()); // setting the name of the first candidate

        // setting the details of second candidate
        candidate1Icon.setIcon(candidate1.getCandidateImage()); // setting the icon of second candidate
        candidate1Name.setText(candidate1.getCandidateName()); // setting the name of the second candidate

        if (selectedOffice == SRCSecretaryCheckBox) { // if secretary checkbox is selected
            if (candidates.length != 0) { // if the length is not 0
                for (Candidate candidate : candidates) { // for candidate in candidates
                    candidate2Icon.setIcon(candidate.getCandidateImage()); // set the icon of the icon label to the candidates image
                    candidate2Name.setText(candidate.getCandidateName()); // set the text of the name label to the candidates name
                }
                candidate2Box.setVisible(true); // set the visibility of candidate2Box checkbox to visible
                candidate2Name.setVisible(true); // do same for the candidate2Name label
                candidate2Icon.setVisible(true); // do same for the candidate2Icon label
            }
        } else {
            candidate2Box.setVisible(false); // set the visibility of the candidate2Box checkbox to hidden
            candidate2Name.setVisible(false); // do same for the candidate2Name label
            candidate2Icon.setVisible(false); // do same for the candidate2Icon label
        }
    }

    // over load the first setCandidatesForVote method so that we can use different parameter requirements
    void setCandidatesForVote(Candidate noCandidate) {
        candidate1Name.setText(noCandidate.getCandidateName());
    }

    // function to confirm vote
    void confirmVote() {
        confirmVotePane.setVisible(true); // break the default settings and set its visibility to true (confirmVotePane)

        confirmVoteFrame = new JFrame("Confirm Vote"); // complete the declaration of the frame
        candidateOfficeConfirm.setText(selectedOffice.getText() + "?"); // set the candidateOfficeConfirm label to the text of the selected office
        candidateNameConfirm.setText(selectedCandidName); // set the text of the candidateNameConfirm label to the selected candidate name
        confirmCandidateImage.setIcon(candidConfirmIcon); // do same for the icon
        confirmVoteFrame.setContentPane(confirmVotePane); // set the content pane
        confirmVoteFrame.setSize(400, 200); // dimension of the frame
        confirmVoteFrame.setLocationRelativeTo(null); // relative location
        confirmVoteFrame.setVisible(true); // visibility to true
        enableButtons(0, backNavButton); // toggle the enablement of the backNavButton to off
        // adding a window listener to the frame
        confirmVoteFrame.addWindowListener(new WindowListener() {
            @Override
            public void windowOpened(WindowEvent e) {

            }

            @Override
            public void windowClosing(WindowEvent e) {

            }

            @Override
            public void windowClosed(WindowEvent e) {

            }

            @Override
            public void windowIconified(WindowEvent e) {

            }

            @Override
            public void windowDeiconified(WindowEvent e) {

            }

            @Override
            public void windowActivated(WindowEvent e) {

            }

            @Override
            public void windowDeactivated(WindowEvent e) { // such that, if the window gets deactivated,
                enableLabels(1, candidate0Name, candidate1Name, candidate2Name); // enable the candidate name labels
                enableCheckBoxes(1, candidate0Box, candidate1Box, candidate2Box); // enable the candidate checkboxes
                enableButtons(1, backNavButton); // enable the back nav button
                deselectCheckBoxes(candidate0Box, candidate1Box, candidate2Box); // deselect the candidate boxes
            }
        });
    }

    // method to save user's vote
    void saveVote(JCheckBox portfolio) {
        if (portfolio == SRCPresidentCheckBox) {
            ++ presidentialVoteCounter;

            // error handling
            if (presidentialOffice.getVoterIDs()[14] == null) {
                presidentialOffice.getVoterIDs()[presidentialVoteCounter] = voter_id;
            }
        }

        else if (portfolio == SRCSecretaryCheckBox) {
            ++ secretarialVoteCounter;

            if (secretarialOffice.getVoterIDs()[14] == null) {
                secretarialOffice.getVoterIDs()[secretarialVoteCounter] = voter_id;
            }
        }

        else if (portfolio == SRCTreasurerCheckBox) {
            ++ treasurerVoteCounter;

            if (treasurerOffice.getVoterIDs()[14] == null) {
                treasurerOffice.getVoterIDs()[treasurerVoteCounter] = voter_id;
            }
        }
    }

    // method to alert a successful vote
    void alertVoteSuccess() {
        voteAlertPane.setVisible(true);

        voteAlertFrame = new JFrame("Vote Success");
        alertCandidName.setText(selectedCandidName);
        alertPortfolioName.setText(selectedOffice.getText() + "!");
        alertVoteImage.setIcon(candidConfirmIcon);
        voteAlertFrame.setContentPane(voteAlertPane);
        voteAlertFrame.setSize(550, 190);
        voteAlertFrame.setAlwaysOnTop(true);
        voteAlertFrame.setLocationRelativeTo(null);
        voteAlertFrame.setVisible(true);

        // adding window listener voteAlertFrame
        voteAlertFrame.addWindowListener(new WindowListener() {
            @Override
            public void windowOpened(WindowEvent e) {

            }

            @Override
            public void windowClosing(WindowEvent e) {

            }

            @Override
            public void windowClosed(WindowEvent e) {

            }

            @Override
            public void windowIconified(WindowEvent e) {

            }

            @Override
            public void windowDeiconified(WindowEvent e) {

            }

            @Override
            public void windowActivated(WindowEvent e) {

            }

            @Override
            public void windowDeactivated(WindowEvent e) { // such that if the window is deactivated
                    // if the votedState property of all the checkboxes is true
                if (presidentialOffice.getVotedState() && secretarialOffice.getVotedState() && treasurerOffice.getVotedState()) {
                    swapPanes(verifyVoterIDPane, candidatePane); // swap the panes... meaning display the verifyVoterIDPane over the candidatePane
                    currentPane = verifyVoterIDPane; // set the currentPane to the verifyVoterIDPane

                    SRCPresidentCheckBox.setEnabled(presidentialOffice.getVotedState()); // set the enabled property of presidential checkbox based its votedState
                    SRCSecretaryCheckBox.setEnabled(secretarialOffice.getVotedState()); // do same for secretary checkbox
                    SRCTreasurerCheckBox.setEnabled(treasurerOffice.getVotedState()); // do same for treasurer checkbox

                    presidentialOffice.setVotedState(false); // reset the votedState of the presidential office to false
                    secretarialOffice.setVotedState(false); // do same for secretary checkbox
                    treasurerOffice.setVotedState(false); // do same here too
                } else { // else,
                    swapPanes(portfolioPane, candidatePane); // swap the panes to the portfolio pane
                    currentPane = portfolioPane; // set the current pane to portfolio pane

                    // set the enabled property of presidential checkbox based its votedState. but this time, in the opposite way... pay attention to the '!' character
                    SRCPresidentCheckBox.setEnabled(!presidentialOffice.getVotedState());
                    SRCSecretaryCheckBox.setEnabled(!secretarialOffice.getVotedState()); // do same here
                    SRCTreasurerCheckBox.setEnabled(!treasurerOffice.getVotedState()); // and here too
                }

                deselectCheckBoxes(selectedOffice); // deselect the selected office
                enableButtons(0, backNavButton); // toggle the enablement of the backNavButton to 0

            }
        });
    }

    // method to set the candidate results
    void setCandidateResults() {
        // this block sets the icons for all the candidate
        can0VoteIcon.setIcon(presidentCandidate0.getCandidateImage());
        can1VoteIcon.setIcon(presidentCandidate1.getCandidateImage());
        can2VoteIcon.setIcon(secretaryCandidate0.getCandidateImage());
        can3VoteIcon.setIcon(secretaryCandidate1.getCandidateImage());
        can4VoteIcon.setIcon(treasurerCandidate0.getCandidateImage());
        can5VoteIcon.setIcon(treasurerCandidate1.getCandidateImage());
        can6VoteIcon.setIcon(secretaryCandidate2.getCandidateImage());

        // this block sets the names of all the candidates
        can0VoteName.setText(presidentCandidate0.getCandidateName());
        can1VoteName.setText(presidentCandidate1.getCandidateName());
        can2VoteName.setText(secretaryCandidate0.getCandidateName());
        can3VoteName.setText(secretaryCandidate1.getCandidateName());
        can4VoteName.setText(treasurerCandidate0.getCandidateName());
        can5VoteName.setText(treasurerCandidate1.getCandidateName());
        can6VoteName.setText(secretaryCandidate2.getCandidateName());

        // set the vote count of all the candidates
        can0VoteCount.setText(String.valueOf(presidentCandidate0.getCandidateVotes()));
        can1VoteCount.setText(String.valueOf(presidentCandidate1.getCandidateVotes()));
        can2VoteCount.setText(String.valueOf(secretaryCandidate0.getCandidateVotes()));
        can3VoteCount.setText(String.valueOf(secretaryCandidate1.getCandidateVotes()));
        can4VoteCount.setText(String.valueOf(treasurerCandidate0.getCandidateVotes()));
        can5VoteCount.setText(String.valueOf(treasurerCandidate1.getCandidateVotes()));
        can6VoteCount.setText(String.valueOf(secretaryCandidate2.getCandidateVotes()));
    }

    // setting up the menu bar
    JMenuBar MenuBar() {

        JMenuBar menuBar = new JMenuBar(); // creating menu bar

        // creating menu
        JMenu fileMenu = new JMenu("File"); // creating the 'File' menu
        JMenu displayMenu = new JMenu("Display"); // creating the 'Display' menu
        JMenu helpMenu = new JMenu("Help"); // creating the 'Help' menu
        JMenu viewAddedPortfoliosMenu = new JMenu("Added Portfolios"); // creating the 'Added Portfolios' menu

        // creating menu items
        JMenuItem addItem = new JMenuItem("Add"); // creating the 'Add' menu item
        JMenuItem exitItem = new JMenuItem("Exit"); // creating the 'Exit' menu item
        JMenuItem resultItem = new JMenuItem("Result"); // creating the 'Result' menu item
        JMenuItem aboutItem = new JMenuItem("About"); // creating the 'About' menu item

        // adding menu items to various menu
        fileMenu.add(addItem); // adding 'Add' menu item to 'File' menu
        fileMenu.add(exitItem); // adding 'Exit' menu item to 'File' menu
        displayMenu.add(resultItem); // adding the 'Result' menu item to the 'Display' menu
        helpMenu.add(aboutItem); // adding the 'About' menu item to the 'Help' menu

        // setting mnemonics to menu items
        addItem.setMnemonic(KeyEvent.VK_A);
        exitItem.setMnemonic(KeyEvent.VK_F4);

        // setting mnemonics to the various menus
        fileMenu.setMnemonic(KeyEvent.VK_F);
        displayMenu.setMnemonic(KeyEvent.VK_D);
        helpMenu.setMnemonic(KeyEvent.VK_H);
        viewAddedPortfoliosMenu.setMnemonic(KeyEvent.VK_P);
        addItem.setMnemonic(KeyEvent.VK_A);
        exitItem.setMnemonic(KeyEvent.VK_E);
        resultItem.setMnemonic(KeyEvent.VK_R);
        aboutItem.setMnemonic(KeyEvent.VK_A);

        // settings accelerators
        addItem.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_A, InputEvent.ALT_DOWN_MASK));
        exitItem.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_F4, InputEvent.ALT_DOWN_MASK));
        aboutItem.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_H, InputEvent.CTRL_DOWN_MASK));
        resultItem.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_R, InputEvent.CTRL_DOWN_MASK));

        // adding various menu to menu bar
        menuBar.add(fileMenu); // adding 'File' menu to 'Menu Bar'
        menuBar.add(displayMenu); // adding 'Display' menu to 'Menu Bar'
        menuBar.add(helpMenu); // adding 'Help' menu to 'Menu Bar'
        menuBar.add(viewAddedPortfoliosMenu); // adding 'Added Portfolios' to 'Menu Bar'

        // adding action listener to exitItem
        exitItem.addActionListener(exitItemAction -> System.exit(3));

        // adding action listener to aboutItem
        aboutItem.addActionListener(aboutItemAction -> swapPanes(helpPane, verifyVoterIDPane, voteResultsPane, portfolioPane, candidatePane, confirmVotePane, addNewPortfolioPane, viewAddedPortfolioPane, voteAlertPane));

        // adding action listener to resultItem
        resultItem.addActionListener(resultItemAction -> {
            // show the first parameter and hide the rest using the swapPanes method
            swapPanes(voteResultsPane, verifyVoterIDPane, portfolioPane, candidatePane, confirmVotePane, helpPane, addNewPortfolioPane, viewAddedPortfolioPane, voteAlertPane);
            setCandidateResults(); // call the setCandidateResults method to set the results
        });

        // creating mouse listener to menu items
        MouseListener menuMouseListener = new MouseListener() {
            @Override
            public void mouseClicked(MouseEvent e) {
                if (!Objects.equals(newPort0Label.getText(), "")) { // if the label of the first "newly added portfolio" is not empty
                    showLabels(1, newPort0Label); // toggle the visibility of the label to true
                    showCheckBoxes(1, newPort0); // toggle the visibility of the checkbox to true
                    showLabels(0, newPortMessageLabel); // toggle the visibility of the message label to false
                    newPortMessageLabel.setText(""); // set the text of the message label to empty
                }

                else if (!Objects.equals(newPort1Label.getText(), "")) { // if the second label is not empty
                    showLabels(1, newPort1Label); // do same
                    showCheckBoxes(1, newPort1); // do same
                }

                else if (!Objects.equals(newPort2Label.getText(), "")) { // if the third label is not empty
                    showLabels(1, newPort2Label); // do same
                    showCheckBoxes(1, newPort2); // do same
                }

                // swap panes to viewAddedPortfolioPane
                swapPanes(viewAddedPortfolioPane, verifyVoterIDPane, helpPane, voteResultsPane, portfolioPane, candidatePane, confirmVotePane, addNewPortfolioPane, voteAlertPane);
            }

            @Override
            public void mousePressed(MouseEvent e) {}

            @Override
            public void mouseReleased(MouseEvent e) {}

            @Override
            public void mouseEntered(MouseEvent e) {}

            @Override
            public void mouseExited(MouseEvent e) {}
        };

        // adding mouse listener to viewAddedPortfolioMenu menu
        viewAddedPortfoliosMenu.addMouseListener(menuMouseListener);

        // adding action listener to addItem
        addItem.addActionListener(addItemAction -> swapPanes(addNewPortfolioPane, verifyVoterIDPane, portfolioPane, candidatePane, voteResultsPane, helpPane, viewAddedPortfolioPane));

        // setting the value of this method to menu bar
        return menuBar;
    }

    SRCMain() {
        // swapPanes here set the visibility of the rest of the panes to false
        swapPanes(verifyVoterIDPane, portfolioPane, candidatePane, confirmVotePane, voteAlertPane, viewAddedPortfolioPane, voteResultsPane, addNewPortfolioPane, helpPane);
        currentPane = verifyVoterIDPane; // set the current pane to verify voters id pane
        mainFrame.setJMenuBar(MenuBar()); // set the menu bar of the main frame to the MenuBar function we set up
        showCheckBoxes(0, newPort0, newPort1, newPort2); // toggle the visibility of the checkboxes to off

        // adding key listener to the voterID input field
        voterID.addKeyListener(new KeyListener() {
            @Override
            public void keyReleased(KeyEvent e) { // on key released
                confirmVoterIDErrorMessage.setText(""); // set the text of the errorLabel to empty
            }

            @Override
            public void keyTyped(KeyEvent e) {}

            @Override
            public void keyPressed(KeyEvent e) {}
        });

        confirmVoterID.addActionListener(confirmVoterIDAction -> {
            if (Objects.equals(voterID.getText(), "")) { // if the voter's id text field is empty
                confirmVoterIDErrorMessage.setText("Provide Voter's ID!"); // set the text of the errorLabel to provide voters id
            }

            else if (voterID.getText().length() > 9 || voterID.getText().length() < 9) { // if the length of the voter id is < 9 or > 9
                confirmVoterIDErrorMessage.setText("Voter's ID must be 9!"); // tell the user the id must be 9
            }

            else { // else
                // if canVote
                if (canVote(voterID.getText(), presidentialOffice.getVoterIDs(), secretarialOffice.getVoterIDs(), treasurerOffice.getVoterIDs())) {

                    // add the portfolios
                    addPortfolio(SRCPresidentCheckBox, presidentialOffice);
                    addPortfolio(SRCSecretaryCheckBox, secretarialOffice);
                    addPortfolio(SRCTreasurerCheckBox, treasurerOffice);

                    // swap the panes to the portfolio pane
                    swapPanes(portfolioPane, verifyVoterIDPane);
                    currentPane = portfolioPane;

                    voter_id = voterID.getText(); // set the voter_id to the user input
                    voterID.setText(""); // clear the input the user gave
                    deselectCheckBoxes(newPort0, newPort1, newPort2);

                } else { // else
                    confirmVoterIDErrorMessage.setText("You already voted"); // tell the user he already voted
                }
            }
        });

        // creating action listener for the portfolios
        ActionListener portfolioAction = portfolioActions -> {
            if (SRCPresidentCheckBox.isSelected()) { // if presidential checkbox is selected
                enableCheckBoxes(0, SRCSecretaryCheckBox, SRCTreasurerCheckBox); // toggle the rest of the checkboxes to off
                selectedOffice = SRCPresidentCheckBox; // set selected office to presidential checkbox
            } else if (SRCSecretaryCheckBox.isSelected()) { // if secretary checkbox is selected
                enableCheckBoxes(0, SRCPresidentCheckBox, SRCTreasurerCheckBox); // toggle the rest of the checkboxes to off
                selectedOffice = SRCSecretaryCheckBox; // set selected office to secretary checkbox
            } else if (SRCTreasurerCheckBox.isSelected()) { // same for this guy
                enableCheckBoxes(0, SRCPresidentCheckBox, SRCSecretaryCheckBox);
                selectedOffice = SRCTreasurerCheckBox;
            } else { // else
                SRCPresidentCheckBox.setEnabled(!presidentialOffice.getVotedState()); // set the enablement of the presidential checkbox to its vote state
                SRCSecretaryCheckBox.setEnabled(!secretarialOffice.getVotedState()); // do same for secretary checkbox
                SRCTreasurerCheckBox.setEnabled(!treasurerOffice.getVotedState()); // do same here
            }

            if (newPort0.isSelected()) { // if newPort0 is selected
                enableCheckBoxes(0, newPort1, newPort2); // toggle the enablement of the rest of the checkboxes (in addedNewPortfolioPane) to false
                enableLabels(0, newPort1Label, newPort2Label); // toggle ane enablement of the rest of the labels to false
                selectedOffice = newPort0; // set the selected Office of newPort0
            } else if (newPort1.isSelected()) { // same applies here
                enableCheckBoxes(0, newPort0, newPort2); // toggle the enablement of the rest of the checkboxes (in addedNewPortfolioPane) to false
                enableLabels(0, newPort0Label, newPort2Label); // toggle enablement of the rest of the labels to false
                selectedOffice = newPort1;
            } else if (newPort2.isSelected()) {
                enableCheckBoxes(0, newPort0, newPort1); // toggle the enablement of the rest of the checkboxes (in addedNewPortfolioPane) to false
                enableLabels(0, newPort0Label, newPort1Label); // toggle ane enablement of the rest of the labels to false
                selectedOffice = newPort2; // toggle enablement of the rest of the labels to false
            } else { // else
                enableCheckBoxes(1, newPort0, newPort1, newPort2); // enable all the checkboxes
                enableLabels(1, newPort0Label, newPort1Label, newPort2Label); // enable all the labels
            }

            // set the enablement of the nextNavButton to one of this states
            nextNavButton.setEnabled(
                SRCPresidentCheckBox.isSelected() || // the state where the SRCPresidentCheckBox is selected
                SRCSecretaryCheckBox.isSelected() ||
                SRCTreasurerCheckBox.isSelected() ||
                newPort0.isSelected() ||
                newPort1.isSelected() ||
                newPort2.isSelected()
            );
        };

        // adding the portfolioAction to the checkboxes
        SRCPresidentCheckBox.addActionListener(portfolioAction);
        SRCSecretaryCheckBox.addActionListener(portfolioAction);
        SRCTreasurerCheckBox.addActionListener(portfolioAction);
        newPort0.addActionListener(portfolioAction);
        newPort1.addActionListener(portfolioAction);
        newPort2.addActionListener(portfolioAction);

        // nextNavButton's actionListener
        nextNavButton.addActionListener(nextNavAction -> {
            if (currentPane == portfolioPane) { // if the portfolioPane is the current pane
                if (!Objects.equals(voter_id, "")) {
                    if (selectedOffice == SRCPresidentCheckBox) { // if the office selected is the presidential office,
                        setCandidatesForVote(presidentCandidate0, presidentCandidate1); // set presidential candidates for vote
                    }

                    else if (selectedOffice == SRCSecretaryCheckBox) {
                        setCandidatesForVote(secretaryCandidate0, secretaryCandidate1, secretaryCandidate2);
                    }

                    else if (selectedOffice == SRCTreasurerCheckBox) {
                        setCandidatesForVote(treasurerCandidate0, treasurerCandidate1);
                    }

                    // else if selected office is either of the new portfolio check boxes,
                    else if (selectedOffice == newPort0 || selectedOffice == newPort1 || selectedOffice == newPort2) {
                        setCandidatesForVote(new Candidate("No candidates for this portfolio")); // set an empty candidate
                        showCheckBoxes(0, candidate0Box, candidate1Box, candidate2Box);
                    }

                    swapPanes(candidatePane, portfolioPane); // swap candidatePane with portfolio pane
                    currentPane = candidatePane; // set current pane to candidatePane
                    enableButtons(1, backNavButton); // enable backNabButton
                } else
                    swapPanes(verifyVoterIDPane, currentPane, viewAddedPortfolioPane, voteResultsPane, addNewPortfolioPane, helpPane);
            }

            else if (currentPane == candidatePane) { //else if candidate pane is the current pane
                confirmVote(); // confirm vote
                enableLabels(0, candidate0Name, candidate1Name, candidate2Name); // toggle the enablement of the labels to off
                enableCheckBoxes(0, candidate0Box, candidate1Box, candidate2Box); // toggle the enablement of the checkbox to off
            }

            enableButtons(0, nextNavButton); // toggle the enablement of the nextNavButton to 0
        });

        // adding action listener backNavButton
        backNavButton.addActionListener(backNavAction -> {
            if (currentPane == candidatePane) { // if current pane == candidate pane
                enableButtons(0, backNavButton); // disable backNavButton
                swapPanes(portfolioPane, candidatePane); // swap panes
                currentPane = portfolioPane; // set current pane to portfolio pane
            }

            else if (currentPane == confirmVotePane) { // else if current pane == confirm vote pane
                swapPanes(candidatePane, confirmVotePane); // swap panes
                currentPane = candidatePane; // set current pane to candidate pane
            }

            deselectCheckBoxes(SRCPresidentCheckBox, SRCSecretaryCheckBox, SRCTreasurerCheckBox, candidate0Box, candidate1Box, candidate2Box, newPort0, newPort1, newPort2);
            enableLabels(1, candidate0Name, candidate1Name, candidate2Name);
            clearLabels(candidate1Name, candidate0Icon, candidate1Icon, candidate2Name, candidate2Icon);
            showCheckBoxes(1, candidate0Box, candidate1Box);
            enableCheckBoxes(1, candidate0Box, candidate1Box, candidate2Box);

            SRCPresidentCheckBox.setEnabled(!presidentialOffice.getVotedState());
            SRCSecretaryCheckBox.setEnabled(!secretarialOffice.getVotedState());
            SRCTreasurerCheckBox.setEnabled(!treasurerOffice.getVotedState());

            enableButtons(0, nextNavButton); // set nextNavButton's state to 0: which means off
        });

        // creating action listener for candidates
        ActionListener selectedCandidateAction = selectedCandidate -> {
            if (candidate0Box.isSelected()) { // if the first candidate box is selected,
                selectedCandid = candidate0Box; // set
                selectedCandidName = candidate0Name.getText();
                candidConfirmIcon = (ImageIcon) candidate0Icon.getIcon();
                enableLabels(0, candidate1Name, candidate2Name);
                enableCheckBoxes(0, candidate1Box, candidate2Box);
            }

            else if (candidate1Box.isSelected()) {
                selectedCandid = candidate1Box;
                selectedCandidName = candidate1Name.getText();
                candidConfirmIcon = (ImageIcon) candidate1Icon.getIcon();
                enableLabels(0, candidate0Name, candidate2Name);
                enableCheckBoxes(0, candidate0Box, candidate2Box);
            }

            else if (candidate2Box.isSelected()) {
                selectedCandid = candidate2Box;
                selectedCandidName = candidate2Name.getText();
                candidConfirmIcon = (ImageIcon) candidate2Icon.getIcon();
                enableLabels(0, candidate0Name, candidate1Name);
                enableCheckBoxes(0, candidate0Box, candidate1Box);
            }

            else {
                selectedCandid = null;
                selectedCandidName = null;
                candidConfirmIcon = null;
                enableLabels(1, candidate0Name, candidate1Name, candidate2Name);
                enableCheckBoxes(1, candidate0Box, candidate1Box, candidate2Box);
            }

            nextNavButton.setEnabled(candidate0Box.isSelected() || candidate1Box.isSelected() || candidate2Box.isSelected());
        };

        candidate0Box.addActionListener(selectedCandidateAction);
        candidate1Box.addActionListener(selectedCandidateAction);
        candidate2Box.addActionListener(selectedCandidateAction);

        ActionListener closePanes = closePanesAction -> swapPanes(currentPane, verifyVoterIDPane, viewAddedPortfolioPane, voteResultsPane, addNewPortfolioPane, helpPane);

        closeAddPortfolioPane.addActionListener(closePanes);
        closeHelpPane.addActionListener(closePanes);
        closeVotesPane.addActionListener(closePanes);
        closeViewAddedPortfolioPane.addActionListener(closePanes);
        nextNavButton.addActionListener(closePanes);
        backNavButton.addActionListener(closePanes);

        closeViewAddedPortfolioPane.addActionListener(closeViewAddedPortfolioPaneAction -> deselectCheckBoxes(newPort0, newPort1, newPort2));

        cancelButton.addActionListener(cancelVoteAction -> {
            enableLabels(1, candidate0Name, candidate1Name, candidate2Name);
            enableCheckBoxes(1, candidate0Box, candidate1Box, candidate2Box);
            enableButtons(1, backNavButton);
            deselectCheckBoxes(candidate0Box, candidate1Box, candidate2Box);
            confirmVoteFrame.setVisible(false);
        });

        voteButton.addActionListener(voteButtonAction -> {
            if (selectedCandid == candidate0Box) {
                if (selectedOffice == SRCPresidentCheckBox) {
                    presidentCandidate0.setCandidateVotes(presidentCandidate0.getCandidateVotes() + 1);
                    presidentialOffice.setVotedState(true);
                }
                else if (selectedOffice == SRCSecretaryCheckBox) {
                    secretaryCandidate0.setCandidateVotes(secretaryCandidate0.getCandidateVotes() + 1);
                    secretarialOffice.setVotedState(true);
                }
                else if (selectedOffice == SRCTreasurerCheckBox) {
                    treasurerCandidate0.setCandidateVotes(treasurerCandidate0.getCandidateVotes() + 1);
                    treasurerOffice.setVotedState(true);
                }
            }

            else if (selectedCandid == candidate1Box) {
                if (selectedOffice == SRCPresidentCheckBox) {
                    presidentialOffice.setVotedState(true);
                    presidentCandidate1.setCandidateVotes(presidentCandidate1.getCandidateVotes() + 1);
                }
                else if (selectedOffice == SRCSecretaryCheckBox) {
                    secretaryCandidate1.setCandidateVotes(secretaryCandidate1.getCandidateVotes() + 1);
                    secretarialOffice.setVotedState(true);
                }
                else if (selectedOffice == SRCTreasurerCheckBox) {
                    treasurerCandidate1.setCandidateVotes(treasurerCandidate1.getCandidateVotes() + 1);
                    treasurerOffice.setVotedState(true);
                }
            }

            else if (selectedCandid == candidate2Box) {
                secretaryCandidate2.setCandidateVotes(secretaryCandidate2.getCandidateVotes() + 1);
                secretarialOffice.setVotedState(true);
            }

            enableCheckBoxes(1, candidate0Box, candidate1Box, candidate2Box);
            deselectCheckBoxes(candidate0Box, candidate1Box, candidate2Box);
            enableLabels(1, candidate0Name, candidate1Name, candidate2Name);
            enableButtons(0, backNavButton);
            saveVote(selectedOffice);

            confirmVoteFrame.setVisible(false);
            alertVoteSuccess();
        });

        OKButton.addActionListener(OKAction -> voteAlertFrame.setVisible(false));

        addPortfolioButton.addActionListener(addPortfolioAction -> {
            if (!Objects.equals(portfolioName.getText(), "")) {
                Portfolio addedPortfolio = new Portfolio(portfolioName.getText());

                if (newPort0Label.getText().isEmpty()) {
                    addPortfolio(newPort0, newPort0Label, addedPortfolio);
                    errorLabel.setText(addedPortfolio.getPortfolioName() + " successfully added");
                } else if (newPort1Label.getText().isEmpty()) {
                    addPortfolio(newPort1, newPort1Label, addedPortfolio);
                    errorLabel.setText(addedPortfolio.getPortfolioName() + " successfully added");
                } else if (newPort2Label.getText().isEmpty()) {
                    addPortfolio(newPort2, newPort2Label, addedPortfolio);
                    errorLabel.setText(addedPortfolio.getPortfolioName() + " successfully added");
                } else {
                    errorLabel.setText("Portfolio slots filled up!");
                }
            } else {
                errorLabel.setText("Provide portfolio name");
            }

            portfolioName.setText("");
        });

        portfolioName.addKeyListener(new KeyListener() {
            @Override
            public void keyTyped(KeyEvent e) {

            }

            @Override
            public void keyPressed(KeyEvent e) {
                errorLabel.setText("");
            }

            @Override
            public void keyReleased(KeyEvent e) {

            }
        });
    }

    public static void main(String[] args) {
        mainFrame = new JFrame("ATU Electoral Commission");
        mainFrame.setContentPane(new SRCMain().mainPane);
        mainFrame.setSize(600, 580);
        mainFrame.setLocationRelativeTo(null);
        mainFrame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        mainFrame.setVisible(true);
    }
}
