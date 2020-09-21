#include <iostream>
#include <string>
#include <cstring>
#include <vector>
#include <algorithm>
#include <math.h>

using namespace std;

int main() {
    int n, m;

    cin >> n >> m;

    if (n == 1) {
        cout << 1 << '\n';
    }
    else if (n == 2) {
        if (m < 7) {
            cout << (m+1)/2 << '\n';
        }
        else { cout << 4 << '\n'; }
    }
    else {
        if (m < 7) {
            cout << min(4, m) << '\n';
        }
        else {
            cout << m-2 << '\n';
        }
    }

    return 0;
}