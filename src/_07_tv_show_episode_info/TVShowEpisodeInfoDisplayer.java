package _07_tv_show_episode_info;


import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class TVShowEpisodeInfoDisplayer implements ActionListener {
	JTextField m_text = new JTextField();
	public TVShowEpisodeInfoDisplayer() {
		m_text = createShowInput();
		JButton submit = createSubmitButton();
		JFrame frame = new JFrame();
		JPanel panel = new JPanel();
		panel.add(m_text);
		panel.add(submit);
		frame.add(panel);
		frame.setVisible(true);
		frame.pack();
	}
	private JTextField createShowInput(){
		JTextField text = new JTextField();
		text.setPreferredSize(new Dimension(200,30));
		return text;
	}
	private JButton createSubmitButton(){
		JButton submit = new JButton();
		submit.setText("Submit");
		submit.addActionListener(this);
		return submit;
	}
	
	
	

/////////////////////////DO NOT MODIFY ANY CODE BELOW THIS LINE//////////////////////////////////////////
	
	/**
	 * Searches the tvmaze.com api for season and episode information about
	 * a chosen show and returns the information in a String
	 * 
	 * @param showTitle	the name of the show to get information about
	 * @return 			a String containing the show information or a blank
	 * 					String if the show is not found
	 */
	public String getShowEpisodeData(String showTitle) {
		int id = WebUtilities.getShowId(showTitle);
		if(id < 0) {
			return "";
		}
		
		int totalSeasons = 0;
		int totalEpisodes = 0;
		int[] episodes = null;
		
		try {
			URL url = new URL("https://api.tvmaze.com/shows/"+id+"/seasons");
			HttpURLConnection connection = (HttpURLConnection) url.openConnection();
			InputStream responseStream = connection.getInputStream();
			String in = WebUtilities.getStringFromInputStream(responseStream);
			String[] info = WebUtilities.parseJSONArray(in);
			totalSeasons = info.length;
			episodes = new int[totalSeasons];
			boolean success = true;
			for(int i = 0; i < totalSeasons; i++) {
				try {
					episodes[i] = WebUtilities.getIntFromJSONObject(info[i], "episodeOrder");
				}catch(Exception e) {
					episodes[i] = -1;
					success = false;
				}
				totalEpisodes += episodes[i];
			}
			if(!success) {
				JOptionPane.showMessageDialog(null, "Could not retrieve some or all of the episode data.", "Data Not Available", 0);
			}
		} catch (MalformedURLException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		String res = showTitle + "\nTotal Seasons: " + totalSeasons + "\nTotal Episodes: " + totalEpisodes + '\n';
		for(int i = 0; i < totalSeasons; i++) {
			res += "Season " + (i + 1) +": " + (episodes[i] > -1 ? episodes[i] : "?") + " episodes\n";
		}
		
		return res;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		//get what the user typed in the JTextField
		String input = m_text.getText();
		if ((input == null) || (input.isEmpty())) {
			JOptionPane.showMessageDialog(null,"PLEASE PUT A SHOW NAME IN I BEG OF YOU \uD83D\uDE2D\uD83D\uDE2D\uD83D\uDE2D");

		}
		else {
			String output = getShowEpisodeData(input);
			if ((output == null) || (output.isEmpty())){
				JOptionPane.showMessageDialog(null,"This show doesn't exist or you made a typo.");
			}
			else {
				JOptionPane.showMessageDialog(null, output);
			}

		}
	}
}
