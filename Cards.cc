#include<iostream>
#include<cstdlib>
using namespace std;

class Card {
	string suit_;
	int value_;
	
public:

	Card() {
		suit_ = "Pika";
		value_ = 15;
	}	
	
	string get_suit() {
		return suit_;
	}
	
	int get_value() {
		return value_;
	}
	
	void set_suit(string suit) {
		suit_ = suit;
	}
	
	void set_value(int value) {
		value_ = value;
	}
	
	void print() {
		cout << get_suit() << " - " << get_value() << endl;
	}
};

class Deck {
	Card cards_[52];
	
public:
	Deck () {
		string suits[] = {"Spades", "Diamonds", "Hearts", "Clubs"};
		int l = 0;
		for(int k = 0; k < 4; k++) {
			for(int i = 2; i < 16; i++) {
				if (i != 11) {
					cards_[l].set_value(i);
					cards_[l].set_suit(suits[k]);
					l++;
				}
			}
		}	
	}
	
	void shuffle() {
		int random;
		Card temp;
		for (int i = 0; i < 52; i++) {
			random = (rand()%52) ;
			temp = cards_[i];
			cards_[i] = cards_[random];
			cards_[random] = temp;
		}
	}
	
	Card at(int i) {
		if(i > 0 && i < 52) {
			Card card = cards_[i];
			return card;
		}
	}
	
	void print() {
		for(int i = 0; i < 52; i++) {
			cards_[i].print();
			
		}
	}
};

int main () {
	Deck deck;
	deck.print();
	deck.shuffle();
	deck.print();
	Card card = deck.at(32);
	cout << "#######################" << endl;
	card.print();
	return 0;
}
