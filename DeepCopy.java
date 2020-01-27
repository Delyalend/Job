import java.lang.reflect.Field;
import java.lang.reflect.Modifier;
import java.util.ArrayList;
import java.util.List;

public class DeepCopy {

        public static Object CopyObject(Object object) {
            try {

                Object clone = object.getClass().newInstance();

                for (Field field : object.getClass().getDeclaredFields()) {
                    field.setAccessible(true);

                    if (field.get(object) == null || Modifier.isFinal(field.getModifiers())) {
                        continue;
                    }


                    if(field.getType().equals(List.class)) {

                            List list = (List)field.get(object);

                            if(field.get(object) instanceof ArrayList) {
                                List copyList = new ArrayList();
                                for (int i = 0; i < list.size(); i++) {
                                    copyList.add(list.get(i));
                                }
                                field.set(clone, copyList);
                            }
                    }
                    else if(field.getType().isPrimitive()
                            || field.getType().equals(String.class)
                            || field.getType().getSuperclass().equals(Number.class)
                            || field.getType().equals(Boolean.class)) {
                        field.set(clone, field.get(object));
                    }
                    else {
                        Object childObj = field.get(object);
                        if(childObj == object) {
                            field.set(clone,clone);
                        }
                        else {
                            field.set(clone,CopyObject(field.get(object)));
                        }
                    }
                }
                return clone;
            }
            catch(Exception e)
            {
                System.out.println("Error: " + e.toString());
                return null;
            }
        }
}
