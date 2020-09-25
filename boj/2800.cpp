#include <iostream>
#include <bitset> 
#include <string>
#include <cstring>
#include <vector>
#include <algorithm>
#include <math.h>

using namespace std;
typedef pair<int, int> p;

int main() {
    string s;
    cin >> s;

    vector<int> st; // 스택
    vector<p> plist; // 괄호 인덱스 백터

    for(int i=0; i<s.size(); i++) {
        if (s[i] == '(') st.push_back(i);
        if (s[i] == ')') {
            plist.push_back(p(st.back(), i));
            st.pop_back();
        }
    }

    vector<string> answer;

    for (int i=1; i<(int)(pow(2,plist.size())); i++) {
        bitset<10> _bit(i);

        bool del[201] = {false};
        for (int j=0; j<plist.size(); j++) {
            if (!_bit[j]) continue;
            p cur = plist[j];
            del[cur.first] = del[cur.second] = true;
        }

        string tmp;
        for (int k = 0; k < s.size(); ++k) {
            if (!del[k]) tmp.push_back(s[k]);
        }
        answer.push_back(tmp);
    }
    sort(answer.begin(), answer.end());

    string before;
    for (int i=0; i<answer.size(); i++) {
        if (before.compare(answer[i]) == 0) continue;
        cout << answer[i] << '\n'; 
        before = answer[i];
    }

    return 0;
}
