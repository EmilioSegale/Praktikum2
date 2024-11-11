package factory;

import java.io.IOException;

public class ConcreteCreatorCsv extends Creator{
	@Override
	public Product factoryMethod() throws IOException {
		return new ConcreteProductCsv();
	}

}
