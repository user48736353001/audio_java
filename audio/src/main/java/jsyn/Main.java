package jsyn;

import com.jsyn.*; //añadimos librería jsyn
import com.jsyn.devices.AudioDeviceManager;


public class Main {
    public static void main(String[] args) {
        int i=44100;
        int numInputChannels=2;
        int numOutputChannels=2;


       Synthesizer synth = JSyn.createSynthesizer();
       synth.start(i, AudioDeviceManager.USE_DEFAULT_DEVICE, numInputChannels, AudioDeviceManager.USE_DEFAULT_DEVICE,
               numOutputChannels);
       synth.stop();//finalización de ejecucion de Jsynth
    }
}