package symbol_table;

import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

public class SymbolTable {

    // ===================== Symbol Kind =====================
    // نوع الرمز (مهم لاحقًا في Semantic Analysis)
    public enum SymbolKind {
        VARIABLE,
        FUNCTION,
        ROUTE,
        LOOP_VARIABLE,
        PARAMETER
    }

    // ===================== Symbol Entry =====================
    public static class SymbolEntry {
        private final String name;
        private Object value;
        private SymbolKind kind;
        private final HashMap<String, Object> attributes = new HashMap<>();

        public SymbolEntry(String name) {
            this(name, null, null);
        }

        public SymbolEntry(String name, Object value) {
            this(name, value, null);
        }

        public SymbolEntry(String name, Object value, SymbolKind kind) {
            this.name = name;
            this.value = value;
            this.kind = kind;
        }

        public String getName() {
            return name;
        }

        public Object getValue() {
            return value;
        }

        public void setValue(Object value) {
            this.value = value;
        }

        public SymbolKind getKind() {
            return kind;
        }

        public void setKind(SymbolKind kind) {
            this.kind = kind;
        }

        // ---------- Attributes ----------
        public void setAttribute(String key, Object value) {
            attributes.put(key, value);
        }

        public Object getAttribute(String key) {
            return attributes.get(key);
        }

        public Map<String, Object> getAllAttributes() {
            return attributes;
        }
    }

    // ===================== Symbol Table Core =====================
    private final Stack<HashMap<String, SymbolEntry>> scopes = new Stack<>();

    public SymbolTable() {
        enterScope(); // Global Scope
    }

    // دخول Scope جديد
    public void enterScope() {
        scopes.push(new HashMap<>());
    }

    // الخروج من Scope
    public void exitScope() {
        if (!scopes.isEmpty()) {
            scopes.pop();
        }
    }

    // ===================== Insert =====================
    public boolean insert(String name) {
        return insert(name, null, null);
    }

    public boolean insert(String name, Object value) {
        return insert(name, value, null);
    }

    public boolean insert(String name, Object value, SymbolKind kind) {
        if (scopes.isEmpty()) {
            enterScope();
        }

        HashMap<String, SymbolEntry> currentScope = scopes.peek();
        if (currentScope.containsKey(name)) {
            return false; // الرمز موجود مسبقًا في نفس الـ scope
        }

        currentScope.put(name, new SymbolEntry(name, value, kind));
        return true;
    }

    // ===================== Lookup =====================
    public SymbolEntry lookup(String name) {
        for (int i = scopes.size() - 1; i >= 0; i--) {
            HashMap<String, SymbolEntry> scope = scopes.get(i);
            if (scope.containsKey(name)) {
                return scope.get(name);
            }
        }
        return null;
    }

    // ===================== Debug Print =====================
    public void print(String indent) {
        int scopeIndex = 0;

        for (HashMap<String, SymbolEntry> scope : scopes) {
            System.out.println(indent + "=== Scope " + scopeIndex + " ===");

            for (SymbolEntry entry : scope.values()) {
                System.out.print(indent + "- " + entry.getName());

                if (entry.getKind() != null) {
                    System.out.print(" [" + entry.getKind() + "]");
                }

                if (entry.getValue() != null) {
                    System.out.print(" = " + entry.getValue());
                }

                System.out.println();

                for (Map.Entry<String, Object> attr : entry.getAllAttributes().entrySet()) {
                    System.out.println(indent + "    • " + attr.getKey() + " : " + attr.getValue());
                }
            }

            scopeIndex++;
        }
    }
}
