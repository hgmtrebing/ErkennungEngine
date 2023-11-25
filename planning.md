
# Erkennung Engine Planning

## 2023-11-25

The Erkennung Engine will be the central library that drives Erkennung. It should have minimal dependencies, and perhaps not even be runnable. The ultimate idea is that the Erkennung Engine can be imported as a dependency to a Spring Boot-based RESTful API Server, a Command Line app, and the like.

Some central features and requirements of Erkennung:
- Each language should be placed in its own package (i.e., us.hgmtrebing.erkennung.deutsch)
- The programming/metalanguage of each package should be English
- The Erkennung German Engine should support the following features:
  - Grammatical constants for Gender, Case, Number, Article-Type
  - Articles:
    - Ability to get master list of articles
    - Ability to get filtered list of articles on Gender, Case, Number, and Article-Type
    - Ability to obtain exact article form, based on provided Gender, Case, Number, and Article-Type

There will be more features after this, but this is a good start.

The ErkennungApiServer and ErkennungUI should be developed in tandem.