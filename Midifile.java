package MIDI;

import javax.sound.midi.*;
import java.io.*;
import java.awt.event.*;
import javax.swing.*;

public class Midifile {
    public static void main(String[] args) throws IOException {
		JTextField textField = new JTextField();
        
        textField.addKeyListener(new MKeyListener());
        
        JFrame jframe = new JFrame();
        
        jframe.add(textField);
        
        jframe.setSize(400, 350);
        
        jframe.setVisible(true);
	}
}

class MKeyListener extends KeyAdapter {
	
	public static void playNote(int freq, MidiChannel[] mChannels, char note)
    {
    	mChannels[0].noteOn(freq, 100);
        try { Thread.sleep(250);
        } catch( InterruptedException e ) {
            e.printStackTrace();
        }
        mChannels[0].noteOff(freq);
    }

	public static void playRest(MidiChannel[] mChannels)
    {
    	mChannels[0].noteOn(0, 0);
        try { Thread.sleep(250);
        } catch( InterruptedException e ) {
            e.printStackTrace();
        }
        mChannels[0].noteOff(0);
    }

	public static void keyHeld(int KeyCode) throws InterruptedException
	{
		if (KeyStroke.getKeyStroke(KeyCode, 0) == null)
			throw new InterruptedException();
	}

    @Override
    public void keyPressed(KeyEvent event) {
        
        char ch = event.getKeyChar();
        
        try{
	        /* 
	         * C blues: c2f3g5C5g3f2c
	         * Amogus: dfg4gfd___cfd___dfg4gf4___4gf4gfd_dfg4gfd___cfd___dfg4gf4___4gf4gfd
	         */
	        Synthesizer midiSynth = MidiSystem.getSynthesizer(); 
	        midiSynth.open();
	    
	        //get and load default instrument and channel lists
	        Instrument[] instr = midiSynth.getDefaultSoundbank().getInstruments();
	        MidiChannel[] mChannels = midiSynth.getChannels();
	        
	        midiSynth.loadInstrument(instr[0]);//load an instrument
			
			playRest(mChannels);
	        	switch(ch)
	        	{
	        		case 'a':
	        			playNote(60, mChannels, ch);
	        			break;
	        		case 's':
	        			playNote(62, mChannels, ch);
	        			break;
	        		case 'd':
	        			playNote(64, mChannels, ch);
	        			break;
	        		case 'f':
	        			playNote(65, mChannels, ch);
	        			break;
	        		case 'g':
	        			playNote(67, mChannels, ch);
	        			break;
	        		case 'h':
	        			playNote(69, mChannels, ch);
	        			break;
	        		case 'j':
	        			playNote(71, mChannels, ch);
	        			break;
	        		case 'k':
	        			playNote(72, mChannels, ch);
	        			break;
	        		case 'l':
	        			playNote(74, mChannels, ch);
	        			break;
	        		// case 'E':
	        		// 	playNote(76, mChannels);
	        		// 	break;
	        		// case 'F':
	        		// 	playNote(77, mChannels);
	        		// 	break;
	        		// case 'G':
	        		// 	playNote(79, mChannels);
	        		// 	break;
	        		// case 'A':
	        		// 	playNote(81, mChannels);
	        		// 	break;
	        		// case 'B':
	        		// 	playNote(83, mChannels);
	        		// 	break;
	        		case 'w':
	        			playNote(61, mChannels, ch);
	        			break;
	        		case 'e':
	        			playNote(63, mChannels, ch);
	        			break;
	        		case 't':
	        			playNote(66, mChannels, ch);
	        			break;
	        		case 'y':
	        			playNote(68, mChannels, ch);
	        			break;
	        		case 'u':
	        			playNote(70, mChannels, ch);
	        			break;
	        		case 'o':
	        			playNote(73, mChannels, ch);
	        			break;
	        		case 'p':
	        			playNote(75, mChannels, ch);
	        			break;
	        		// case '#':
	        		// 	playNote(78, mChannels);
	        		// 	break;
	        		// case '$':
	        		// 	playNote(80, mChannels);
	        		// 	break;
	        		// case '%':
	        		// 	playNote(82, mChannels);
	        		// 	break;
	        		default:
	        			playRest(mChannels);
	        			break;
	        	}
	        
	    
	    
	      } catch (MidiUnavailableException e) {
	         e.printStackTrace();
	      }
    }
}