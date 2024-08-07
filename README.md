<div align="center">
</br>
<img src="https://plus.unsplash.com/premium_photo-1669927131902-a64115445f0f?q=80&w=3550&auto=format&fit=crop&ixlib=rb-4.0.3&ixid=M3wxMjA3fDB8MHxwaG90by1wYWdlfHx8fGVufDB8fHx8fA%3D%3D"/>
</div>

</br>

<p align="center">
  <img src="https://forthebadge.com/images/badges/built-for-android.svg"><br>
   <img src="https://user-images.githubusercontent.com/57827233/136597211-06f60356-8aa3-494b-8c4b-189bd975c29f.jpg" width="320">
</p>
<p align="center">
  <img src="https://img.shields.io/github/repo-size/hiten24/compose-ui-templates">
  <img alt="GitHub" src="https://img.shields.io/github/license/hiten24/compose-ui-templates?color=blue">
</p>
<p align="center">
  <img src="https://img.shields.io/badge/kotlin-%230095D5.svg?style=for-the-badge&logo=kotlin&logoColor=white">
</p>

</br>

# CitiesApp

In Cities, we need to search for cities based on a prefix input by the user. While there are several methods to achieve this, using a Trie (prefix tree) provides significant advantages over a simple linear search, especially when dealing with a large dataset such as 200k cities.


## Features

- **Fast and Efficient Search:** Search cities based on the prefix of their names.
- **Modern UI:** Built with Jetpack Compose for a modern and reactive UI.

</br>

### Comparison Table

| Feature                      | Linear Search                               | Trie                                        |
|------------------------------|---------------------------------------------|---------------------------------------------|
| **Time Complexity**          | O(n)                                        | O(k)                                        |
| **Space Complexity**         | O(n)                                        | O(n * k)                                    |
| **Search Speed**             | Slower with larger datasets                 | Faster, constant time for prefix search     |
| **Insertion Speed**          | Fast (simply add to the end of the list)    | Slower (needs to update the Trie structure) |
| **Memory Usage**             | Lower (depends on the size of the list)     | Higher (requires additional storage for nodes and pointers) |
| **Implementation Complexity**| Simple and straightforward                  | More complex, requires understanding of Trie structure |
| **Use Case Suitability**     | Small datasets or infrequent searches       | Large datasets, frequent and fast prefix searches |

</br>

## Prerequisites

- **Android Studio Arctic Fox** or later
- **Kotlin 1.5** or later
- **Gradle 7.0** or later

## Getting Started

### Cloning the Repository

```bash
git clone https://github.com/hossamsadekk/cities.git
cd CitiesApp





