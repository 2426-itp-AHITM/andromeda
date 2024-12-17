import json

class listBuilder: 
    def __init__(self, json_file_path):
<<<<<<< Updated upstream
        self.actions = self._load_actions_from_file(json_file_path)
    
=======
        list_loader = listLoader()
        self.actions = list_loader.getUserPrompts(json_file_path,1)
        #self.actions.append(list_loader.getUserPrompts("",""))
        #self.actions = self._load_actions_from_file(json_file_path)
        
>>>>>>> Stashed changes
    def _load_actions_from_file(self, file_path):
        try:
            with open(file_path, 'r', encoding='utf-8') as file:
                return json.load(file)
        except FileNotFoundError:
            raise FileNotFoundError(f"File not found: {file_path}")
        except json.JSONDecodeError:
            raise ValueError(f"Invalid JSON in file: {file_path}")
    
    def format_actions(self):
        if not isinstance(self.actions, list):
            raise ValueError("The JSON file must contain a list of actions.")
        formatted_list = [
            f'{index + 1}: "{action}"' for index, action in enumerate(self.actions)
        ]
        return f"Liste: ({', '.join(formatted_list)})"