import javax.swing.*;
import java.awt.event.*;
import java.util.Arrays;
import java.util.Objects;

public class SRCMain {

    // setting presidential candidates
    public static Candidate presidentCandidate0 = new Candidate("White Barbie", new ImageIcon("C:\\Users\\Hash\\IdeaProjects\\SRCVoteAPP\\src\\images\\pres0Image.PNG"));
    public static Candidate presidentCandidate1 = new Candidate("Martin Dukes", new ImageIcon("C:\\Users\\Hash\\IdeaProjects\\SRCVoteAPP\\src\\images\\pres1Image.PNG"));

    // setting secretarial candidates
    public static Candidate secretaryCandidate0 = new Candidate("Amos Blue", new ImageIcon("C:\\Users\\Hash\\IdeaProjects\\SRCVoteAPP\\src\\images\\sec0Image.PNG"));
    public static Candidate secretaryCandidate1 = new Candidate("Wallace Brown", new ImageIcon("C:\\Users\\Hash\\IdeaProjects\\SRCVoteAPP\\src\\images\\sec1Image.PNG"));
    public static Candidate secretaryCandidate2 = new Candidate("Latest Candid", new ImageIcon("C:\\Users\\Hash\\IdeaProjects\\SRCVoteAPP\\src\\images\\sec0Image.PNG"));

    // setting treasurer candidates
    public static Candidate treasurerCandidate0 = new Candidate("James Caster", new ImageIcon("C:\\Users\\Hash\\IdeaProjects\\SRCVoteAPP\\src\\images\\tre0Image.PNG"));
    public static Candidate treasurerCandidate1 = new Candidate("Spencer James", new ImageIcon("C:\\Users\\Hash\\IdeaProjects\\SRCVoteAPP\\src\\images\\tre1Image.PNG"));

    // setting portfolios
    public static Portfolio presidentialOffice = new Portfolio("SRC President"); // setting presidential office
    public static Portfolio secretarialOffice = new Portfolio("SRC Secretary"); // secretarial office
    public static Portfolio treasurerOffice = new Portfolio("SRC Treasurer"); // treasurer office

    private JPanel mainPane, portfolioPane, candidatePane, confirmVotePane, voteResultsPane, helpPane, addNewPortfolioPane, viewAddedPortfolioPane;
    private JButton backNavButton, nextNavButton;
    private JCheckBox SRCTreasurerCheckBox, SRCSecretaryCheckBox, SRCPresidentCheckBox, candidate0Box;
    private JLabel candidate0Icon,candidate0Name, candidate1Icon, candidate1Name;

    private JCheckBox candidate1Box, candidate2Box;
    private JLabel candidate2Icon, candidate2Name;
    private JLabel confirmCandidateImage, candidateOfficeConfirm, candidateNameConfirm;

    private JButton voteButton;
    private JButton cancelButton;
    private JPanel voteAlertPane;
    private JLabel alertImage;
    private JButton OKButton;
    private JLabel voteAlertMessage;
    private JLabel can0VoteIcon, can0VoteName, can1VoteIcon, can2VoteIcon, can3VoteIcon, can4VoteIcon, can5VoteIcon, can1VoteName;
    private JLabel can2VoteName, can3VoteName, can5VoteName, can4VoteName, can0VoteCount, can1VoteCount, can2VoteCount, can3VoteCount;
    private JLabel can4VoteCount, can5VoteCount, can6VoteCount, can6VoteName, can6VoteIcon;
    private JButton closeVotesPane;
    private JButton closeHelpPane;
    private JButton closeViewAddedPortfolioPane;
    private JButton closeAddPortfolioPane;
    private JLabel errorLabel;
    private JButton addPortfolioButton;
    private JTextField portfolioName;
    private JCheckBox newPort0;
    private JCheckBox newPort1;
    private JCheckBox newPort2;
    private JPanel verifyVoterID;
    private JTextField studentIDTF;
    private JButton confirmButton;
    private JLabel confirmVoterIDErrorMessage;

    private JPanel currentPane;
    private JCheckBox selectedOffice;
    private JCheckBox selectedCandid;
    private String selectedCandidName;
    private ImageIcon candidConfirmIcon;

    private JFrame confirmVoteFrame;
    private JFrame voteAlertFrame;
    private static JFrame mainFrame;

    String[] presidentialArray = new String[15];
    String[] secretarialArray = new String[15];
    String[] treasurerArray = new String[15];

    // counter for each portfolio to detect the number of votes they have
    int presidentialVoteCounter = -1;
    int secretarialVoteCounter = -1;
    int treasurerVoteCounter = -1;

    // states for portfolio check buttons
    boolean presCheck = true;
    boolean secCheck = true;
    boolean treCheck = true;

    // method to help us switch between various panels
    void swapPanes(JPanel panel0, JPanel...otherPanels) {
        panel0.setVisible(true); // set the first parameter's visibility to true

        // for the other parameters,
        for (JPanel panel : otherPanels) {
            if (panel != panel0)
                panel.setVisible(false); // set their visibility to false
        }
    }

    // method to helps us to toggle buttons to disable or enable
    void enableButtons(int state, JButton...jButtons) {
        for (JButton jButton: jButtons) {
            jButton.setEnabled(state != 0);
        }
    }

    // method to toggle checkboxes to enable or disable
    void enableCheckBoxes(int state, JCheckBox...jCheckBoxes) {
        for (JCheckBox jCheckBox : jCheckBoxes) {
            jCheckBox.setEnabled(state != 0);
        }
    }

    // method to toggle checkboxes to selected or deselected
    void selectCheckBoxes(int state, JCheckBox...jCheckBoxes) {
        for(JCheckBox checkBox : jCheckBoxes) {
            checkBox.setSelected(state != 0);
        }
    }

    // method to disable or enable labels
    void enableLabels(int state, JLabel...jLabels) {
        for (JLabel jLabel : jLabels) {
            jLabel.setEnabled(state != 0);
        }
    }

    // method to remove the text and icons of labels
    void clearLabels(JLabel...jLabels) {
        for (JLabel jLabel : jLabels) {
            jLabel.setIcon(null);
            jLabel.setText("");
        }
    }

    // method to show or hide checkboxes
    void showCheckBoxes(int state, JCheckBox...jCheckBoxes) {
        for (JCheckBox checkBox : jCheckBoxes) {
            checkBox.setVisible(state != 0);
        }
    }

    // function to confirm vote
    void confirmVote() {
        confirmVotePane.setVisible(true);

        confirmVoteFrame = new JFrame("Confirm Vote");
        candidateOfficeConfirm.setText(selectedOffice.getText() + "?");
        candidateNameConfirm.setText(selectedCandidName);
        confirmCandidateImage.setIcon(candidConfirmIcon);
        confirmVoteFrame.setContentPane(confirmVotePane);
        confirmVoteFrame.setSize(400, 200);
        confirmVoteFrame.setLocationRelativeTo(null);
        confirmVoteFrame.setVisible(true);

        confirmVoteFrame.addWindowListener(new WindowListener() {
            @Override
            public void windowOpened(WindowEvent e) {
//                System.out.println("Window Opened");
            }

            @Override
            public void windowClosing(WindowEvent e) {
//                System.out.println("Window Closing");
            }

            @Override
            public void windowClosed(WindowEvent e) {
//                System.out.println("Window Closed");
            }

            @Override
            public void windowIconified(WindowEvent e) {
//                System.out.println("Window Iconified");
            }

            @Override
            public void windowDeiconified(WindowEvent e) {
//                System.out.println("Window Deiconified");
            }

            @Override
            public void windowActivated(WindowEvent e) {
//                System.out.println("Window Activated");
            }

            @Override
            public void windowDeactivated(WindowEvent e) {
                //System.out.println("Window Deactivated");
                enableLabels(1, candidate0Name, candidate1Name, candidate2Name);
                enableCheckBoxes(1, candidate0Box, candidate1Box, candidate2Box);
                enableButtons(1, backNavButton);
                selectCheckBoxes(0, candidate0Box, candidate1Box, candidate2Box);
            }
        });
    }

    // method to alert a successful vote
    void alertVoteSuccess() {
        voteAlertPane.setVisible(true);

        voteAlertFrame = new JFrame("Vote Success");
        voteAlertMessage.setText("Successfully Voted " + selectedCandidName + " as " + selectedOffice.getText() + "!");
        alertImage.setIcon(candidConfirmIcon);
        voteAlertFrame.setContentPane(voteAlertPane);
        voteAlertFrame.setSize(550, 190);
        voteAlertFrame.setAlwaysOnTop(true);
        voteAlertFrame.setLocationRelativeTo(null);
        voteAlertFrame.setVisible(true);

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
            public void windowDeactivated(WindowEvent e) {
//                swapPanes(verifyVoterID, candidatePane);
//                currentPane = verifyVoterID;

                if ((!presCheck && !secCheck && !treCheck)) {
                    swapPanes(verifyVoterID, candidatePane);
                    currentPane = verifyVoterID;
                } else {
                    if (selectedOffice == SRCPresidentCheckBox) {

                        enableCheckBoxes(0, SRCPresidentCheckBox);

                        enableCheckBoxes(1, SRCSecretaryCheckBox, SRCTreasurerCheckBox, candidate0Box, candidate1Box, candidate2Box);
                        enableLabels(1, candidate0Name, candidate1Name, candidate2Name);

                        SRCPresidentCheckBox.removeActionListener(SRCOffice);
                        presCheck = false;
                    }

                    else if (selectedOffice == SRCSecretaryCheckBox) {

                        enableCheckBoxes(0, SRCSecretaryCheckBox);

                        enableCheckBoxes(1, SRCPresidentCheckBox, SRCTreasurerCheckBox, candidate0Box, candidate1Box, candidate2Box);
                        enableLabels(1, candidate0Name, candidate1Name, candidate2Name);

                        SRCSecretaryCheckBox.removeActionListener(SRCOffice);
                        secCheck = false;
                    }

                    else if (selectedOffice == SRCTreasurerCheckBox) {

                        enableCheckBoxes(0, SRCTreasurerCheckBox);

                        enableCheckBoxes(1, SRCPresidentCheckBox, SRCSecretaryCheckBox, candidate0Box, candidate1Box, candidate2Box);
                        enableLabels(1, candidate0Name, candidate1Name, candidate2Name);

                        SRCTreasurerCheckBox.removeActionListener(SRCOffice);
                        treCheck = false;
                    }

                    if (!presCheck)
                        enableCheckBoxes(0, SRCPresidentCheckBox);
                    else if (!secCheck)
                        enableCheckBoxes(0, SRCSecretaryCheckBox);
                    else if (!treCheck)
                        enableCheckBoxes(0, SRCTreasurerCheckBox);
                    else
                        enableCheckBoxes(1, SRCTreasurerCheckBox, SRCPresidentCheckBox, SRCSecretaryCheckBox, candidate0Box, candidate1Box, candidate2Box);

                    selectCheckBoxes(0, SRCPresidentCheckBox, SRCSecretaryCheckBox, SRCTreasurerCheckBox, candidate0Box, candidate1Box, candidate2Box);

                    swapPanes(portfolioPane, candidatePane);
                    currentPane = portfolioPane;
                }
            }
        });
    }

    // set up candidate details for vote
    void setCandidatesForVote(Candidate candidate0, Candidate candidate1, Candidate...candidates) {
        // setting the details of first candidate
        candidate0Icon.setIcon(candidate0.getCandidateImage()); // setting the icon of first candidate
        candidate0Name.setText(candidate0.getCandidateName()); // setting the name of the first candidate

        // setting the details of second candidate
        candidate1Icon.setIcon(candidate1.getCandidateImage()); // setting the icon of second candidate
        candidate1Name.setText(candidate1.getCandidateName()); // setting the name of the second candidate

        if (selectedOffice == SRCSecretaryCheckBox) {
            if (candidates.length != 0) {
                for (Candidate candidate : candidates) {
                    candidate2Icon.setIcon(candidate.getCandidateImage());
                    candidate2Name.setText(candidate.getCandidateName());
                }
                candidate2Box.setVisible(true);
                candidate2Name.setVisible(true);
                candidate2Icon.setVisible(true);
            }
        } else {
            candidate2Box.setVisible(false);
            candidate2Name.setVisible(false);
            candidate2Icon.setVisible(false);
        }
    }

    ActionListener SRCOffice = SRCOfficeCheckBoxes -> {
        if (SRCPresidentCheckBox.isSelected()) {
            enableCheckBoxes(0, SRCSecretaryCheckBox, SRCTreasurerCheckBox);
            selectedOffice = SRCPresidentCheckBox;
        }

        else if (SRCSecretaryCheckBox.isSelected()) {
            enableCheckBoxes(0, SRCPresidentCheckBox, SRCTreasurerCheckBox);
            selectedOffice = SRCSecretaryCheckBox;
        }

        else if (SRCTreasurerCheckBox.isSelected()) {
            enableCheckBoxes(0, SRCPresidentCheckBox, SRCSecretaryCheckBox);
            selectedOffice = SRCTreasurerCheckBox;
        }

        else {
            if (!presCheck)
                enableCheckBoxes(1, SRCSecretaryCheckBox, SRCTreasurerCheckBox);

            else if (!secCheck)
                enableCheckBoxes(1, SRCPresidentCheckBox, SRCTreasurerCheckBox);

            else if (!treCheck)
                enableCheckBoxes(1, SRCPresidentCheckBox, SRCSecretaryCheckBox);

            else
                enableCheckBoxes(1, SRCPresidentCheckBox, SRCSecretaryCheckBox, SRCTreasurerCheckBox);

            selectCheckBoxes(0, SRCPresidentCheckBox, SRCSecretaryCheckBox, SRCTreasurerCheckBox);
            selectedOffice = null;
        }

        nextNavButton.setEnabled(SRCPresidentCheckBox.isSelected() || SRCSecretaryCheckBox.isSelected() || SRCTreasurerCheckBox.isSelected());
    };

    void setCandidateResults() {
        can0VoteIcon.setIcon(presidentCandidate0.getCandidateImage());
        can1VoteIcon.setIcon(presidentCandidate1.getCandidateImage());
        can2VoteIcon.setIcon(secretaryCandidate0.getCandidateImage());
        can3VoteIcon.setIcon(secretaryCandidate1.getCandidateImage());
        can4VoteIcon.setIcon(treasurerCandidate0.getCandidateImage());
        can5VoteIcon.setIcon(treasurerCandidate1.getCandidateImage());
        can6VoteIcon.setIcon(secretaryCandidate2.getCandidateImage());

        can0VoteName.setText(presidentCandidate0.getCandidateName());
        can1VoteName.setText(presidentCandidate1.getCandidateName());
        can2VoteName.setText(secretaryCandidate0.getCandidateName());
        can3VoteName.setText(secretaryCandidate1.getCandidateName());
        can4VoteName.setText(treasurerCandidate0.getCandidateName());
        can5VoteName.setText(treasurerCandidate1.getCandidateName());
        can6VoteName.setText(secretaryCandidate2.getCandidateName());

        can0VoteCount.setText(String.valueOf(presidentCandidate0.getNumberOfVotes()));
        can1VoteCount.setText(String.valueOf(presidentCandidate1.getNumberOfVotes()));
        can2VoteCount.setText(String.valueOf(secretaryCandidate0.getNumberOfVotes()));
        can3VoteCount.setText(String.valueOf(secretaryCandidate1.getNumberOfVotes()));
        can4VoteCount.setText(String.valueOf(treasurerCandidate0.getNumberOfVotes()));
        can5VoteCount.setText(String.valueOf(treasurerCandidate1.getNumberOfVotes()));
        can6VoteCount.setText(String.valueOf(secretaryCandidate2.getNumberOfVotes()));
    }

    // check for vote eligibility
    boolean checkVoterID(String voterID, String[] IDArray) {
        // id could be null, so we implement the block in try and catch
        try {
            for (String id : IDArray) {
                if (id.equals(voterID)) {
                    return false;
                }
            }
        } catch (Exception exception) {
            // do nothing
        }

        return true;
    }

    // method to save user's vote
    void saveVote(JCheckBox portfolio, String voterID) {
        if (portfolio == SRCPresidentCheckBox) {
            ++ presidentialVoteCounter;

            if (presidentialArray[14] == null) {
                presidentialArray[presidentialVoteCounter] = voterID;
            }
        }

        else if (portfolio == SRCSecretaryCheckBox) {
            ++ secretarialVoteCounter;

            if (secretarialArray[14] == null) {
                secretarialArray[secretarialVoteCounter] = voterID;
            }
        }

        else if (portfolio == SRCTreasurerCheckBox) {
            ++ treasurerVoteCounter;

            if (treasurerArray[14] == null) {
                treasurerArray[treasurerVoteCounter] = voterID;
            }
        }
    }

    // method to help us set various portfolios
    void addPortfolio(JCheckBox jCheckBox, Portfolio portfolio) {
        jCheckBox.setVisible(true);
        jCheckBox.setText(portfolio.getPortfolioName());
    }

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

        // adding menu items to various menu
        fileMenu.add(addItem); // adding 'Add' menu item to 'File' menu
        fileMenu.add(exitItem); // adding 'Exit' menu item to 'File' menu

        // setting mnemonics to menu items
        addItem.setMnemonic(KeyEvent.VK_A);
        exitItem.setMnemonic(KeyEvent.VK_F4);

        // settings accelerators
        addItem.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_A, InputEvent.ALT_DOWN_MASK));
        exitItem.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_F4, InputEvent.ALT_DOWN_MASK));

        // adding various menu to menu bar
        menuBar.add(fileMenu); // adding 'File' menu to 'Menu Bar'
        menuBar.add(displayMenu); // adding 'Display' menu to 'Menu Bar'
        menuBar.add(helpMenu); // adding 'Help' menu to 'Menu Bar'
        menuBar.add(viewAddedPortfoliosMenu); // adding 'Added Portfolios' to 'Menu Bar'

        // adding action listener to exitItem
        exitItem.addActionListener(exitItemAction -> {
            System.exit(3);
        });

        // creating mouse listener to menu items
        MouseListener menuMouseListener = new MouseListener() {
            @Override
            public void mouseClicked(MouseEvent e) {
                if (e.getSource() == displayMenu) {
                    swapPanes(voteResultsPane, verifyVoterID, portfolioPane, candidatePane, confirmVotePane, helpPane, addNewPortfolioPane, viewAddedPortfolioPane, voteAlertPane);
                    setCandidateResults();
                }

                else if (e.getSource() == helpMenu) {
                    swapPanes(helpPane, verifyVoterID, voteResultsPane, portfolioPane, candidatePane, confirmVotePane, addNewPortfolioPane, viewAddedPortfolioPane, voteAlertPane);
                }

                else if (e.getSource() == viewAddedPortfoliosMenu) {
                    swapPanes(viewAddedPortfolioPane, verifyVoterID, helpPane, voteResultsPane, portfolioPane, candidatePane, confirmVotePane, addNewPortfolioPane, voteAlertPane);
                }
            }

            @Override
            public void mousePressed(MouseEvent e) {

            }

            @Override
            public void mouseReleased(MouseEvent e) {

            }

            @Override
            public void mouseEntered(MouseEvent e) {

            }

            @Override
            public void mouseExited(MouseEvent e) {

            }
        };

        // adding mouse listener to display and help menu
        displayMenu.addMouseListener(menuMouseListener);
        helpMenu.addMouseListener(menuMouseListener);
        viewAddedPortfoliosMenu.addMouseListener(menuMouseListener);

        // adding action listener to addItem
        addItem.addActionListener(addItemAction -> {
            swapPanes(addNewPortfolioPane, verifyVoterID, portfolioPane, candidatePane, voteResultsPane, helpPane, viewAddedPortfolioPane);
        });

        return menuBar;
    }

    SRCMain() {
        mainFrame.setJMenuBar(MenuBar());

        swapPanes(verifyVoterID, portfolioPane, candidatePane, confirmVotePane, voteResultsPane, helpPane, addNewPortfolioPane, viewAddedPortfolioPane, voteAlertPane);
        currentPane = verifyVoterID;

        nextNavButton.addActionListener(nextNavAction -> {
            if (currentPane == portfolioPane) {
                if (selectedOffice == SRCPresidentCheckBox) {
                    setCandidatesForVote(presidentCandidate0, presidentCandidate1);
                }

                else if (selectedOffice == SRCSecretaryCheckBox) {
                    setCandidatesForVote(secretaryCandidate0, secretaryCandidate1, secretaryCandidate2);
                }

                else if (selectedOffice == SRCTreasurerCheckBox) {
                    setCandidatesForVote(treasurerCandidate0, treasurerCandidate1);
                }

                swapPanes(candidatePane, portfolioPane);
                currentPane = candidatePane;
                enableButtons(1, backNavButton);
            }

            else if (currentPane == candidatePane) {
                confirmVote();
                enableLabels(0, candidate0Name, candidate1Name, candidate2Name);
                enableCheckBoxes(0, candidate0Box, candidate1Box, candidate2Box);
                enableButtons(0, backNavButton);
            }

            enableButtons(0, nextNavButton);
        });

        cancelButton.addActionListener(cancelVoteAction -> {
            enableLabels(1, candidate0Name, candidate1Name, candidate2Name);
            enableCheckBoxes(1, candidate0Box, candidate1Box, candidate2Box);
            enableButtons(1, backNavButton);
            selectCheckBoxes(0, candidate0Box, candidate1Box, candidate2Box);
            confirmVoteFrame.setVisible(false);
        });

        voteButton.addActionListener(voteButtonAction -> {
            if (selectedCandid == candidate0Box) {
                if (selectedOffice == SRCPresidentCheckBox) { presidentCandidate0.setNumberOfVotes(presidentCandidate0.getNumberOfVotes() + 1); }
                else if (selectedOffice == SRCSecretaryCheckBox) { secretaryCandidate0.setNumberOfVotes(secretaryCandidate0.getNumberOfVotes() + 1); }
                else if (selectedOffice == SRCTreasurerCheckBox) { treasurerCandidate0.setNumberOfVotes(treasurerCandidate0.getNumberOfVotes() + 1); }
            }

            else if (selectedCandid == candidate1Box) {
                if (selectedOffice == SRCPresidentCheckBox) { presidentCandidate1.setNumberOfVotes(presidentCandidate1.getNumberOfVotes() + 1); }
                else if (selectedOffice == SRCSecretaryCheckBox) { secretaryCandidate1.setNumberOfVotes(secretaryCandidate1.getNumberOfVotes() + 1); }
                else if (selectedOffice == SRCTreasurerCheckBox) { treasurerCandidate1.setNumberOfVotes(treasurerCandidate1.getNumberOfVotes() + 1); }
            }

            else if (selectedCandid == candidate2Box) {
                secretaryCandidate2.setNumberOfVotes(secretaryCandidate2.getNumberOfVotes() + 1);
            }

            confirmVoteFrame.setVisible(false);
            alertVoteSuccess();
        });

        ActionListener selectedCandidateAction = selectedCandidate -> {
            if (candidate0Box.isSelected()) {
                selectedCandid = candidate0Box;
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

        backNavButton.addActionListener(backNavAction -> {
            if (currentPane == candidatePane) {
                enableButtons(0, backNavButton);
                swapPanes(portfolioPane, candidatePane);
                currentPane = portfolioPane;
            }

            else if (currentPane == confirmVotePane) {
                swapPanes(candidatePane, confirmVotePane);
                currentPane = candidatePane;
            }

            selectCheckBoxes(0, SRCPresidentCheckBox, SRCSecretaryCheckBox, SRCTreasurerCheckBox, candidate0Box, candidate1Box, candidate2Box);
            enableLabels(1, candidate0Name, candidate1Name, candidate2Name);
            clearLabels(candidate1Name, candidate0Icon, candidate1Icon, candidate2Name, candidate2Icon);
            showCheckBoxes(1, candidate0Box, candidate1Box);

            if (!presCheck)
                enableCheckBoxes(0, SRCPresidentCheckBox);
            else if (!secCheck)
                enableCheckBoxes(0, SRCSecretaryCheckBox);
            else if (!treCheck)
                enableCheckBoxes(0, SRCTreasurerCheckBox);
            else
                enableCheckBoxes(1, SRCTreasurerCheckBox, SRCPresidentCheckBox, SRCSecretaryCheckBox, candidate0Box, candidate1Box, candidate2Box);

            enableButtons(0, nextNavButton); // set nextNavButton's state to 0: which means off
        });

        OKButton.addActionListener(OKButtonAction -> {
            voteAlertFrame.setVisible(false);
            enableCheckBoxes(1, candidate0Box, candidate1Box, candidate2Box);
            selectCheckBoxes(0, candidate0Box, candidate1Box, candidate2Box);
            enableLabels(1, candidate0Name, candidate1Name, candidate2Name);
            enableButtons(0, backNavButton);
        });

        // setting the office checkboxes to the office names we set previously
        addPortfolio(SRCPresidentCheckBox, presidentialOffice);
        addPortfolio(SRCSecretaryCheckBox, secretarialOffice);
        addPortfolio(SRCTreasurerCheckBox, treasurerOffice);

        SRCPresidentCheckBox.addActionListener(SRCOffice);
        SRCSecretaryCheckBox.addActionListener(SRCOffice);
        SRCTreasurerCheckBox.addActionListener(SRCOffice);

        ActionListener closePanes = closePanesAction -> {
            swapPanes(currentPane, verifyVoterID, viewAddedPortfolioPane, voteResultsPane, addNewPortfolioPane, helpPane);
        };

        closeAddPortfolioPane.addActionListener(closePanes);
        closeHelpPane.addActionListener(closePanes);
        closeVotesPane.addActionListener(closePanes);
        closeViewAddedPortfolioPane.addActionListener(closePanes);

        addPortfolioButton.addActionListener(addPortfolioAction -> {
            if (!Objects.equals(portfolioName.getText(), "")) {
                Portfolio addedPortfolio = new Portfolio(portfolioName.getText());

                if (newPort0.getText().isEmpty()) {
                    addPortfolio(newPort0, addedPortfolio);
                    errorLabel.setText(addedPortfolio.getPortfolioName() + " successfully added");
                } else if (newPort1.getText().isEmpty()) {
                    addPortfolio(newPort1, addedPortfolio);
                    errorLabel.setText(addedPortfolio.getPortfolioName() + " successfully added");
                } else if (newPort2.getText().isEmpty()) {
                    addPortfolio(newPort2, addedPortfolio);
                    errorLabel.setText(addedPortfolio.getPortfolioName() + " successfully added");
                } else {
                    errorLabel.setText("Portfolio slots filled up!");
                }
            } else {
                errorLabel.setText("Provide portfolio name");
            }
        });

        confirmButton.addActionListener(confirmVoterIDAction -> {

            if (studentIDTF.getText().isEmpty()) {
                confirmVoterIDErrorMessage.setText("Enter an ID!");
            }

            else if (studentIDTF.getText().length() < 9 || studentIDTF.getText().length() > 9) {
                confirmVoterIDErrorMessage.setText("ID must be 9");
            }

            else {
                if (checkVoterID(studentIDTF.getText(), presidentialArray) && checkVoterID(studentIDTF.getText(), secretarialArray) && checkVoterID(studentIDTF.getText(), treasurerArray)) {
                    studentIDTF.setText("");
                    swapPanes(portfolioPane, verifyVoterID);
                    currentPane = portfolioPane;
                }
                else {
                    confirmVoterIDErrorMessage.setText("You already voted");
                }
            }
        });

        studentIDTF.addKeyListener(new KeyListener() {
            @Override
            public void keyTyped(KeyEvent e) {

            }

            @Override
            public void keyPressed(KeyEvent e) {
                confirmVoterIDErrorMessage.setText("");
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
