package entities;

public class OrderItem {
	private Integer quantity;
	private Double price;
	private Product product; // atribuição da classe product 
	
	
	public OrderItem() {}
	
	public OrderItem(Integer quantity, Double price, Product product) {
		
		this.quantity = quantity;
		this.price = price;
		this.product = product;
		
	}
	
	
	public Integer getQuantity() {
		return quantity;
	}
	public void setQuantity(Integer quantity) {
		this.quantity = quantity;
	}
	public Double getPrice() {
		return price;
	}
	public void setPrice(Double price) {
		this.price = price;
	}
	
	
	/*métodos*/
	
	/*responsavel por caucular o subtotal do item*/
	public double subTotal() {
		
		return price * quantity;
	}
	
	@Override
	public String toString() {
		return product.getName() 
				+ ", $" 
				+ String.format("%.2f", price) 
				+ ", Quantity: " 
				+ quantity + 
				", Subtotal: $" 
				+ String.format("%.2f", subTotal());
	}
	
	

}
