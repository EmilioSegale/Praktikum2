package factory;

import java.io.IOException;

public abstract class Product {
	public abstract String[] leserAusDatei() throws IOException;
	public abstract void schlieesenDatei() throws IOException;
}
