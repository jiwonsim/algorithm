#include <iostream>
#include <string>
#include <vector>
#include <algorithm>

using namespace std;
typedef long long ll;

bool desc(int a, int b) { return a > b; }

int main() {

    int n;
    cin >> n;

    vector<int> positives;
    vector<int> negatives;

    int result = 0;
    while (n--) {
        int temp;
        cin >> temp;
        if (temp == 1) result += 1;
        else if (temp > 1) positives.push_back(temp);
        else { negatives.push_back(temp); }
    }

    sort(positives.begin(), positives.end(), desc);
    sort(negatives.begin(), negatives.end());


    if (positives.size()%2 == 1) positives.push_back(1);
    if (negatives.size()%2 == 1) negatives.push_back(1);
    for (int i = 0; i < positives.size(); i+=2) {
        result += (positives[i] * positives[i+1]);
    }
    for (int i = 0; i < negatives.size(); i+=2) {
        result += (negatives[i] * negatives[i+1]);
    }

    cout << result << '\n';

    return 0;
}