package projet.gl51.store

import javax.inject.Singleton

@Singleton
class MemoryProductStorage implements ProductStorage {

	private List<Product> products = []

	@Override
	String save(Product p) {
		p.id = UUID.randomUUID().toString()
		products.add(p)
		p.id
	}

	@Override
	void update(String id, Product p) {
		Integer productIndex = products.findIndexOf { it.id == id }
		if (productIndex == -1) throw new NotExistingProductException()
		p.id = id;
		products.set(productIndex, p)
	}

	@Override
	Product getByID(String id) {
		Product product = products.find { it.id == id }
		if (product == null) throw new NotExistingProductException()
		product
	}

	@Override
	void delete(String id) {
	    products.removeIf {it.id==id}
	}

	@Override
	List<Product> all() {
		products
	}

}
