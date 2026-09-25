# MiniBank

A console-based banking system in Java, built as a two-person learning project to master Java and object-oriented programming from the ground up.

## Team

- Viet Nguyen ([@quvicu](https://github.com/quvicu))
- Mert Baruc ([@MertiBerti](https://github.com/MertiBerti))

## Tech Stack

- Java 21
- IntelliJ IDEA
- Git & GitHub (feature branches, pull requests, peer review)

## Project Goals

- Understand core Java and OOP concepts by implementing each one ourselves
- Model a realistic banking domain: accounts, customers, transactions, fees and interest
- Work like a real team: every change goes through a pull request and a code review

## Roadmap

| Milestone | Topic | Status |
|---|---|---|
| M0 | Setup & basics: interest calculator, account menu | In progress |
| M1 | Methods & strings: amount formatting, IBAN validation | Planned |
| M2 | Arrays: multiple accounts, monthly overview | Planned |
| M3 | Classes & objects: `Account`, `Customer`, `Transaction` | Planned |
| M4 | Inheritance: checking and savings accounts | Planned |
| M5 | Interfaces & polymorphism: fee models | Planned |
| M6 | Algorithms: sorting, binary search, loan amortization | Planned |

## Conventions

- Code, class names and commit messages in English
- Commit messages in imperative mood, e.g. `Add withdraw method to Account`
- Branch names: `feature/m<nr>-<short-description>`
- Monetary amounts are stored in cents as `long`, never as `double`
- No direct pushes to `main` – every change needs a pull request with one approval

## How to Run

1. Clone the repository: `git clone https://github.com/quvicu/minibank.git`
2. Open the project in IntelliJ IDEA
3. Run the `main` method of the desired class
