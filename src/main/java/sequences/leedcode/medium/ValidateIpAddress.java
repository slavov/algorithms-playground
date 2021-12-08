package sequences.leedcode.medium;

/**
 * Write a function to check whether an input string is a valid IPv4 address or IPv6 address or
 * neither.
 *
 * <p>IPv4 addresses are canonically represented in dot-decimal notation, which consists of four
 * decimal numbers, each ranging from 0 to 255, separated by dots ("."), e.g.,172.16.254.1;
 *
 * <p>Besides, leading zeros in the IPv4 is invalid. For example, the address 172.16.254.01 is
 * invalid.
 *
 * <p>IPv6 addresses are represented as eight groups of four hexadecimal digits, each group
 * representing 16 bits. The groups are separated by colons (":"). For example, the address
 * 2001:0db8:85a3:0000:0000:8a2e:0370:7334 is a valid one. Also, we could omit some leading zeros
 * among four hexadecimal digits and some low-case characters in the address to upper-case ones, so
 * 2001:db8:85a3:0:0:8A2E:0370:7334 is also a valid IPv6 address(Omit leading zeros and using upper
 * cases).
 *
 * <p>However, we don't replace a consecutive group of zero value with a single empty group using
 * two consecutive colons (::) to pursue simplicity. For example, 2001:0db8:85a3::8A2E:0370:7334 is
 * an invalid IPv6 address.
 *
 * <p>Besides, extra leading zeros in the IPv6 is also invalid. For example, the address
 * 02001:0db8:85a3:0000:0000:8a2e:0370:7334 is invalid.
 *
 * <p>Note: You may assume there is no extra space or special characters in the input string.
 *
 * <p>Example 1:
 *
 * <p>Input: "172.16.254.1"
 *
 * <p>Output: "IPv4"
 *
 * <p>Explanation: This is a valid IPv4 address, return "IPv4". Example 2:
 *
 * <p>Input: "2001:0db8:85a3:0:0:8A2E:0370:7334"
 *
 * <p>Output: "IPv6"
 *
 * <p>Explanation: This is a valid IPv6 address, return "IPv6". Example 3:
 *
 * <p>Input: "256.256.256.256"
 *
 * <p>Output: "Neither"
 *
 * <p>Explanation: This is neither a IPv4 address nor a IPv6 address.
 *
 * <p>LeetCode: <a href="https://leetcode.com/problems/validate-ip-address/">468. Validate IP
 * Address</a>
 */
public class ValidateIpAddress {

    public static final String NEITHER = "Neither";
    public static final String IPV4 = "IPv4";
    public static final String IPV6 = "IPv6";

    public String validIPAddress(String ip) {
        if (ip.chars().filter(c -> c == '.').count() == 3) {
            return validateIp4(ip);
        } else if (ip.chars().filter(c -> c == ':').count() == 7) {
            return validateIp6(ip);
        } else {
            return NEITHER;
        }
    }

    private String validateIp4(String ip) {
        String[] str = ip.split("\\.");
        if (str.length != 4) {
            return NEITHER;
        }
        for (String s : str) {
            if (s.isEmpty()) {
                return NEITHER;
            }
            if (s.startsWith("0") && s.length() > 1) {
                return NEITHER;
            }
            for (char c : s.toCharArray()) {
                if (!Character.isDigit(c)) {
                    return NEITHER;
                }
            }
            if (s.length() > 3 || Integer.parseInt(s) > 255) {
                return NEITHER;
            }
        }
        return IPV4;
    }

    private String validateIp6(String ip) {
        String[] parts = ip.split(":");
        if (parts.length != 8) {
            return NEITHER;
        }
        for (String s : parts) {
            if (s.length() == 0 || s.length() > 4) {
                return NEITHER;
            }
            for (char c : s.toLowerCase().toCharArray()) {
                if (!Character.isDigit(c) && !(c >= 'a' && c <= 'f')) {
                    return NEITHER;
                }
            }
        }
        return IPV6;
    }
}
