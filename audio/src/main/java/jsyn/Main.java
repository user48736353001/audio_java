package jsyn;

import com.jsyn.*; //añadimos librería jsyn
import com.jsyn.devices.AudioDeviceManager;
import com.jsyn.unitgen.LineOut;
import com.jsyn.unitgen.SpectralFilter;
import com.jsyn.unitgen.WhiteNoise;


public class Main {
    public static void main(String[] args) {
        int i=44100;
        int numInputChannels=2;
        int numOutputChannels=2;

        LineOut myOut;
        WhiteNoise myNoise;
        SpectralFilter myFilter;


       Synthesizer synth = JSyn.createSynthesizer();
       synth.start(i, AudioDeviceManager.USE_DEFAULT_DEVICE, numInputChannels, AudioDeviceManager.USE_DEFAULT_DEVICE,
               numOutputChannels);

       //creación de generadores de onda

        synth.add( myOut = new LineOut());
        //generador de ruido blanco
        synth.add( myNoise = new WhiteNoise());
       //creación de filtro;
        synth.add( myFilter = new SpectralFilter());

        //conexionado de los generadores.
        myNoise.output.connect(myFilter.input);






        //salidas estéreo
        myFilter.output.connect(0,myOut.input,0);
        myFilter.output.connect(0,myOut.input,1);


       synth.stop();//finalización de ejecucion de Jsynth
    }
}