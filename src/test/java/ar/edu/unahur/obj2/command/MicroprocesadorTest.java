package ar.edu.unahur.obj2.command;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import ar.edu.unahur.obj2.command.comandos.ADD;
import ar.edu.unahur.obj2.command.comandos.LOD;
import ar.edu.unahur.obj2.command.comandos.LODV;
import ar.edu.unahur.obj2.command.comandos.NOP;
import ar.edu.unahur.obj2.command.comandos.Operable;
import ar.edu.unahur.obj2.command.comandos.STR;
import ar.edu.unahur.obj2.command.comandos.SWAP;

import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;
import java.util.List;

public class MicroprocesadorTest {
	private List<Operable> listaDeInstrucciones = new ArrayList<>();
	private Programable micro;
	
	@BeforeEach
	void setUp() {
		listaDeInstrucciones.add(new NOP());
		listaDeInstrucciones.add(new NOP());
		listaDeInstrucciones.add(new NOP());
		micro = new Microprocesador(0, 0);
	}
	
	@Test
	void haceAvanzar3PosicionesElPC() {
		micro.run(listaDeInstrucciones);

		
		assertEquals(3, micro.getProgramCounter());
	}
	
	@Test
	void sumarAcumuladores() {
		List<Operable> lista2 = List.of(new LODV(20), new SWAP(), new LODV(17), new ADD());
		micro.run(lista2);
		
		assertEquals(37, micro.getAcumuladorA());
		assertEquals(0, micro.getAcumuladorB());
		assertEquals(4, micro.getProgramCounter());
	}
	
	@Test
	void sumar3Acumuladores() {
		List<Operable> lista3 = List.of(
				new LODV(2), 
				new STR(0), 
				new LODV(8), 
				new SWAP(),
				new LODV(5),
				new ADD(),
				new SWAP(),
				new LOD(0),
				new ADD());
		micro.run(lista3);
	
		
		assertEquals(15, micro.getAcumuladorA());
		assertEquals(0, micro.getAcumuladorB());
	}
}
