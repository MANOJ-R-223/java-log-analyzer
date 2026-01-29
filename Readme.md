# Java Log Analyzer

Java Log Analyzer is a simple command-line tool built using core Java
to analyze log files and extract useful information.

## Features

- Reads log files using BufferedReader
- Counts total log entries
- Detects INFO, WARN, and ERROR log levels
- Detects multiple failed login patterns
- Handles case-insensitive log entries
- Displays count and percentage-based summary
- Accepts log file path as a command-line argument

## Usage

```bash
java LogAnalyzer <log-file-path>
