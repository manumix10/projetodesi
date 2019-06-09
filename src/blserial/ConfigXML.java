package blserial;

import blserial.Config;
import com.thoughtworks.xstream.XStream;
import com.thoughtworks.xstream.annotations.XStreamAlias;
import com.thoughtworks.xstream.io.HierarchicalStreamDriver;
import com.thoughtworks.xstream.io.StreamException;
import com.thoughtworks.xstream.io.xml.Dom4JDriver;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.Reader;
import javax.swing.JOptionPane;

@XStreamAlias(value="config")
public class ConfigXML {
    public Config getConfig(String pCaminhoXML) {
        Config config = new Config();
        try {
            XStream xStream = new XStream((HierarchicalStreamDriver)new Dom4JDriver());
            xStream.alias("config", Config.class);
            xStream.alias("software", String.class);
            xStream.alias("ip", String.class);
            xStream.alias("mac", String.class);
            xStream.alias("dataGeracaoStr", String.class);
            xStream.alias("diasValidadeStr", String.class);
            xStream.alias("dataAtualStr", String.class);
            xStream.processAnnotations(Config.class);
            BufferedReader input = new BufferedReader(new FileReader(pCaminhoXML));
            config = (Config)xStream.fromXML((Reader)input);
            input.close();
        }
        catch (StreamException ex) {
            JOptionPane.showMessageDialog(null, "Erro: Arquivo de configura\u00e7\u00f5es corrompido.");
            System.exit(0);
        }
        catch (IOException ex) {
            JOptionPane.showMessageDialog(null, "Erro: Arquivo de configura\u00e7\u00f5es n\u00e3o encontrado.");
            System.exit(0);
        }
        return config;
    }
}

