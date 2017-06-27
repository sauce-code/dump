package cards;

public class Card implements Comparable<Card> {

	private Color color;

	private Value value;

	public Card(Color color, Value value) {
		super();
		this.color = color;
		this.value = value;
	}

	@Override
	public int compareTo(Card other) {
		return color.compareTo(other.color) * Value.values().length + value.compareTo(other.value);
	}

	@Override
	public String toString() {
		return color.toString() + " " + value.toString();
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((color == null) ? 0 : color.hashCode());
		result = prime * result + ((value == null) ? 0 : value.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Card other = (Card) obj;
		if (color != other.color)
			return false;
		if (value != other.value)
			return false;
		return true;
	}

}
