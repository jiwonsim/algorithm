#include <iostream>
#include <string>
#include <cstring>
#include <vector>
#include <algorithm>
#include <math.h>

using namespace std;
typedef long long ll;

bool desc(int a, int b) { return a > b; }

int main() {

    string input;
    cin >> input;

    int sum = 0;
    for (char c : input) sum += (c-'0');

    sort(input.begin(), input.end(), desc);

    if (input[input.size()-1] == '0' && sum%3 == 0) {
        cout << input << '\n';
    }
    else {
        cout << -1 << '\n';
    }

    return 0;
}