#include <iostream>
#include <string>
#include <cstring>
#include <vector>
#include <algorithm>
#include <math.h>

using namespace std;

int main() {

    string s, t;
    
    cin >> s >> t;

    while (t.length() > s.length()) {
        if (t.back() == 'A') t.pop_back();
        else {
            t.pop_back();
            reverse(t.begin(), t.end());
        }
    }

    if (s==t) cout << 1 << '\n';
    else cout << 0 << '\n';

    return 0;
}