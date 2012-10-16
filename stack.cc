#include<iostream>
#include<list>
using namespace std;

class StackError{
        int error_code_;
public:
        StackError(int error_code){
                error_code_=error_code;
        }
        int get_error_code() {
                return error_code_;
        }
};


class Stack {
	list<int> data_;

public:
	void push(int v) {
		data_.push_back(v);
	}
	
	int pop() {
		int val;
		if(empty()) {
			throw StackError(2);			
		}
		val = data_.back();
		data_.pop_back();
		return val;
	}
	
	bool empty() {
		return data_.empty();
	}
};

int main () {
	Stack st;
	for(int i = 0; i < 100; i++) {
		st.push(i);
	}
	
	try {
		for(int i = 0; i < 100; i++) {
			cout << st.pop() << endl;
		}
		cout << st.pop() <<endl;
	} catch (StackError ex) {
		cout << "Stack is empty" << endl;
	}	
	
	return 0;
}
