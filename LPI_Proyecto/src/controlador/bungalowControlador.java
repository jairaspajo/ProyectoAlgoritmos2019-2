package controlador;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.PrintWriter;
import java.util.ArrayList;

import clases.Bungalow;

public class bungalowControlador {
		private ArrayList<Bungalow> lista2 = new ArrayList<Bungalow>();
	// m�todos b�sicos de la lista
		public bungalowControlador() {
			//apenas se crea el objeto , se crea la data
			//pasa los datos del archivo de texto a la lista
			cargaData();
		}
		public void agregar(Bungalow obj) {
			lista2.add(obj);
		}

		public int tama�o() {
			return lista2.size();
		}

		public Bungalow obtener(int pos) {
			return lista2.get(pos);
		}

		// m�todos adicionales
		public Bungalow buscarPorCodigo(int aux) {
			Bungalow salida = null;
			for (Bungalow x : lista2) {
				if (x.getNumeroBungalow() == aux) {
					salida = x;
					break;
				}
			}
			return salida;
		}

		public void eliminaPorCodigo(int aux) {
			for (Bungalow x : lista2) {
				if (x.getNumeroBungalow() == aux) {
					lista2.remove(x);
					break;
				}
			}
		}

		public void actualizar(Bungalow aux) {
			for (Bungalow x : lista2) {
				if (x.getNumeroBungalow() == aux.getNumeroBungalow()) {
					lista2.set(lista2.indexOf(x), aux);
					break;
				}
			}
		}
		
		private void cargaData(){
			BufferedReader br = null;
			try {
				//Se lee el archivo txt
				br = new BufferedReader(new FileReader("Productos.txt"));
				String linea = null;
				//readLine captura una linea
				while(  (linea = br.readLine()) != null){
						//Se separa los datos
						String[ ]  s = linea.split(";");
						Bungalow obj = new Bungalow();
						obj.setNumeroBungalow(Integer.parseInt(s[0]));
						obj.setCategoria(Integer.parseInt(s[1]));
						obj.setPrecioPorDia(Double.parseDouble(s[2]));
						obj.setEstado(Integer.parseInt(s[3]));
						lista2.add(obj);
				}
			} catch (Exception e) {
				e.printStackTrace();
			} finally{
					try {
						if(br != null) br.close();
					} catch (Exception e) {}
			}
		}
		public void grabarData() {
			PrintWriter pw = null;
			try {
				String linea;
				pw = new PrintWriter(new FileWriter("Productos.txt"));
				for (Bungalow x: lista2) {
					linea = x.getNumeroBungalow() + ";" +   x.getCategoria() + ";" +	x.getPrecioPorDia() + ";" +	x.getEstado();
					pw.println(linea);
				}
			}
			catch (Exception e) {
				e.printStackTrace();
			} finally{
				try {
					if(pw != null) pw.close();
				} catch (Exception e) {}
			}
		}
}
