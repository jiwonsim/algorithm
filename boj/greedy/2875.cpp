#include <iostream>
#include <string>
#include <vector>
#include <algorithm>

using namespace std;
typedef long long ll;

bool desc(int a, int b) { return a > b; }

int main() {

    int n, m, k;
    cin >> n >> m >> k;

    int team = min(n/2, m);
    int intern = (n-team*2) + (m-team);

    if (intern >= k) cout << team << '\n';
    else {
        k -= intern;
        if (k%3 != 0) team-=1;
        team -= k/3;

        cout << team << '\n';
    }

    return 0;
}