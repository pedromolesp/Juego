package graficos;

public final class Pantalla {
	private final int ancho;
	private final int alto;

	// variables temporales
	private final static int LADO_SPRITE = 32;
	private final static int MASCARA_SPRITE = LADO_SPRITE - 1;

	// fin temp
	public final int[] pixeles;

	public Pantalla(final int ancho, final int alto) {
		this.ancho = ancho;
		this.alto = alto;

		pixeles = new int[ancho * alto];

	}

	/*
	 * El próximo método: Limpiar, cambia el valor del color, de todas las
	 * casillas de píxeles, a 0 (en hexadecimal el negro).
	 */
	public void limpiar() {
		for (int i = 0; i < pixeles.length; i++) {
			pixeles[i] = 0;
		}
	}

	public void mostrar(final int compensacionY, final int compensacionX) {
		for (int y = 0; y < alto; y++) {
			int posicionY = y + compensacionY;
			if (posicionY < 0 || posicionY >= alto)
				continue;

			for (int x = 0; x < ancho; x++) {
				int posicionX = x + compensacionX;
				if (posicionX < 0 || posicionX >= ancho)
					continue;

				// código para redibujar

				// temporal (prueba)
				pixeles[posicionX + posicionY * ancho] = Sprite.asfalto.pixeles[(x & MASCARA_SPRITE)
						+ (y & MASCARA_SPRITE) * LADO_SPRITE];
			}

		}

	}
}
