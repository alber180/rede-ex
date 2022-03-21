package rede;

import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Óscar Núñez Aguado <aguado@edu.xunta.es>
 */
public class RedeTest {

    public RedeTest() {
    }

    @Test
    public void validarIP() {
        assertTrue(Rede.validarIP("192.168.0.9"));
        assertTrue(Rede.validarIP("192.168.100.0"));
        assertTrue(Rede.validarIP("255.255.255.255"));
        assertTrue(Rede.validarIP("0.0.0.0"));

        assertFalse(Rede.validarIP(""));
        assertFalse(Rede.validarIP("..."));
        assertFalse(Rede.validarIP("192.168..9"));
        assertFalse(Rede.validarIP("192.168:0.9"));
        assertFalse(Rede.validarIP("192.16x.0.9"));
        assertFalse(Rede.validarIP("192.168.0.009"));
        assertFalse(Rede.validarIP("192.168.0.9."));
        assertFalse(Rede.validarIP(".192.168.0.9"));
        assertFalse(Rede.validarIP("256.0.0.0"));
        assertFalse(Rede.validarIP("255.256.0.0"));
    }

    @Test
    public void buscarIP() {
        String[] ips = {"192.168.0.9", "192.168.100.0", "255.255.255.255", "0.0.0.0"};
        String[] vacio = new String[0];

        assertEquals(Rede.buscarIP("192.168.0.9", ips), 0);
        assertEquals(Rede.buscarIP("192.168.100.0", ips), 1);
        assertEquals(Rede.buscarIP("255.255.255.255", ips), 2);
        assertEquals(Rede.buscarIP("0.0.0.0", ips), 3);

        assertEquals(Rede.buscarIP("192.168.100.9", ips), -1);
        assertEquals(Rede.buscarIP("192.168.0.009", ips), -1);
        assertEquals(Rede.buscarIP("", ips), -1);
        assertEquals(Rede.buscarIP("0.0.0.0", vacio), -1);
    }

    @Test
    public void validarMac() {
        assertTrue(Rede.validarMac("5C260A242A60"));
        assertTrue(Rede.validarMac("5C:26:0A:24:2A:60"));
        assertTrue(Rede.validarMac("5C-26-0A-24-2A-60"));
        assertTrue(Rede.validarMac("5C26.0A24.2A60"));
        assertFalse(Rede.validarMac("5C260A242A6G"));
        assertFalse(Rede.validarMac("5C:26:0A:24:2A.60"));
        assertFalse(Rede.validarMac("5C-26-0A-24-2A-609"));
        assertFalse(Rede.validarMac("5C26.0A24..2A60"));      
    }
}
