#include <iostream>
#include <string>
#include <cstring>
#include <vector>
#include <algorithm>
#include <math.h>

using namespace std;

string popT(string t) {
    t.pop_back();
    return t;
}

string reverseT(string t) {
    reverse(t.begin(), t.end());
    return t;
}

bool available(string s, string t) {
    if (s == t) return true;

    if (t.length() > 0) {
        if (t.back() == 'A' && available(s, popT(t))) {
            return true;
        }
        if (t.front() == 'B' && available(s, popT(reverseT(t)))) {
            return true;
        }
    }

    return false;
}

int main() {
    string s, t;

    cin >> s >> t;
    cout << available(s, t) << '\n';
    return 0;
}