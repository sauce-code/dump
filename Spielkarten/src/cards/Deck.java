package cards;

import static cards.Color.*;
import static cards.Value.*;

import java.util.ArrayList;
import java.util.Collections;

public class Deck {

	private ArrayList<Card> cards;

	public Deck() {
		super();
		cards = new ArrayList<Card>();
	}

	public Deck(Decktype decktype) {
		this();
		switch (decktype) {
		case SKAT:
			addSkatSet();
			break;
		case DURAK:
			addSkatSet();
			addNumbers6();
		case POKER:
			addSkatSet();
			addNumbers6();
			addNumbers2to5();
			break;
		case ROMME_X1:
			addSkatSet();
			addNumbers2to5();
			addNumbers6();
			add3Jokers();
			break;
		case ROMME_X2:
			addSkatSet();
			addNumbers2to5();
			addNumbers6();
			add3Jokers();
			addSkatSet();
			addNumbers2to5();
			addNumbers6();
			add3Jokers();
			break;
		default:
			throw new IllegalArgumentException("no such Enum");
		}
		Collections.sort(cards);
	}

	private void addSkatSet() {
		cards.add(new Card(DIAMONDS, N_7));
		cards.add(new Card(DIAMONDS, N_8));
		cards.add(new Card(DIAMONDS, N_9));
		cards.add(new Card(DIAMONDS, N_10));
		cards.add(new Card(DIAMONDS, JACK));
		cards.add(new Card(DIAMONDS, QUEEN));
		cards.add(new Card(DIAMONDS, KING));
		cards.add(new Card(DIAMONDS, ACE));
		cards.add(new Card(HEARTS, N_7));
		cards.add(new Card(HEARTS, N_8));
		cards.add(new Card(HEARTS, N_9));
		cards.add(new Card(HEARTS, N_10));
		cards.add(new Card(HEARTS, JACK));
		cards.add(new Card(HEARTS, QUEEN));
		cards.add(new Card(HEARTS, KING));
		cards.add(new Card(HEARTS, ACE));
		cards.add(new Card(SPADES, N_7));
		cards.add(new Card(SPADES, N_8));
		cards.add(new Card(SPADES, N_9));
		cards.add(new Card(SPADES, N_10));
		cards.add(new Card(SPADES, JACK));
		cards.add(new Card(SPADES, QUEEN));
		cards.add(new Card(SPADES, KING));
		cards.add(new Card(SPADES, ACE));
		cards.add(new Card(CLUBS, N_7));
		cards.add(new Card(CLUBS, N_8));
		cards.add(new Card(CLUBS, N_9));
		cards.add(new Card(CLUBS, N_10));
		cards.add(new Card(CLUBS, JACK));
		cards.add(new Card(CLUBS, QUEEN));
		cards.add(new Card(CLUBS, KING));
		cards.add(new Card(CLUBS, ACE));
	}

	private void addNumbers6() {
		cards.add(new Card(DIAMONDS, N_6));
		cards.add(new Card(HEARTS, N_6));
		cards.add(new Card(SPADES, N_6));
		cards.add(new Card(CLUBS, N_6));
	}

	private void addNumbers2to5() {
		cards.add(new Card(DIAMONDS, N_2));
		cards.add(new Card(DIAMONDS, N_3));
		cards.add(new Card(DIAMONDS, N_4));
		cards.add(new Card(DIAMONDS, N_5));
		cards.add(new Card(HEARTS, N_2));
		cards.add(new Card(HEARTS, N_3));
		cards.add(new Card(HEARTS, N_4));
		cards.add(new Card(HEARTS, N_5));
		cards.add(new Card(SPADES, N_2));
		cards.add(new Card(SPADES, N_3));
		cards.add(new Card(SPADES, N_4));
		cards.add(new Card(SPADES, N_5));
		cards.add(new Card(CLUBS, N_2));
		cards.add(new Card(CLUBS, N_3));
		cards.add(new Card(CLUBS, N_4));
		cards.add(new Card(CLUBS, N_5));
	}

	private void add3Jokers() {
		cards.add(new Card(NONE, JOKER));
		cards.add(new Card(NONE, JOKER));
		cards.add(new Card(NONE, JOKER));
	}

	public enum Decktype {

		/**
		 * 32 Cards.
		 */
		SKAT,

		/**
		 * 36 Cards.
		 */
		DURAK,

		/**
		 * 52 Cards.
		 */
		POKER,

		/**
		 * 55 Cards (52 + 3 Jokers).
		 */
		ROMME_X1,

		/**
		 * 110 Cards (2x 55).
		 */
		ROMME_X2;
	}

	public ArrayList<Card> getCards() {
		return cards;
	}

	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		sb.append("========= START OF DECK =========");
		sb.append('\n');
		sb.append("=========");
		sb.append(" size: ");
		sb.append(cards.size());
		sb.append(' ');
		sb.append("=========");
		sb.append('\n');
		cards.forEach(card -> sb.append(card.toString() + "\n"));
		sb.append("========= END OF DECK ========= ");
		sb.append('\n');
		return sb.toString();
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((cards == null) ? 0 : cards.hashCode());
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
		Deck other = (Deck) obj;
		if (cards == null) {
			if (other.cards != null)
				return false;
		} else if (!cards.equals(other.cards))
			return false;
		return true;
	}

	public void addRandomCard(Decktype decktype) {
		Deck deck = new Deck(decktype);
		cards.add(deck.cards.get((int) Math.random() * deck.cards.size()));
	}

	public static void main(String[] args) {
		Deck deck = new Deck(Decktype.ROMME_X2);
		Collections.shuffle(deck.getCards());
		Collections.sort(deck.getCards());
		System.out.println(deck);
	}

	public Card draw() {
		return draw(0);
	}
	
	public Card drawRandom() {
		return draw((int) Math.random() * cards.size());
	}
	
	public Card draw(int index) {
		try {
			return cards.remove(index);
		} catch (IndexOutOfBoundsException e) {
			return null;
		}
	}
	
	public void putFirst(Card card) {
		cards.add(0, card);
	}
	
	public void putLast(Card card) {
		cards.add(card);
	}
	
	public void putRandom(Card card) {
		cards.add((int) (Math.random() * cards.size() + 1.0), card);
	}

}
