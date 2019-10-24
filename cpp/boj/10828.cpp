#include <iostream>
#include <stack>
using namespace std;


int main() {
    int N;
    cin >> N;

    stack<int> st;
    string op;

    for (int i = 0; i < N; ++i) {
        cin >> op;
        if (op == "push") {
            int num;
            cin >> num;
            st.push(num);
        }
        if (op == "top") {
            if (st.empty()) {
                cout << "-1" << endl;
            }
            else {
                cout << st.top() << endl;
            }
        }
        if (op == "size") {
            cout << st.size() << endl;
        }
        if (op == "empty") {
            if (st.empty()) cout << "1" << endl;
            else cout << "0" << endl;
        }
        if (op == "pop") {
            if (st.empty()) cout << "-1" << endl;
            else {
                cout << st.top() << endl;
                st.pop();
            }
        }
    }
    return 0;
}
