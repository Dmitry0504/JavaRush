package com.javarush.task.task32.task3209;

import com.javarush.task.task32.task3209.listeners.FrameListener;
import com.javarush.task.task32.task3209.listeners.TabbedPaneChangeListener;
import com.javarush.task.task32.task3209.listeners.UndoListener;

import javax.swing.*;
import javax.swing.undo.UndoManager;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class View extends JFrame implements ActionListener {
    private Controller controller;
    //панель с двумя вкладками
    private JTabbedPane tabbedPane = new JTabbedPane();
    //компонент для визуального редактирования html
    private JTextPane htmlTextPane = new JTextPane();
    //компонент для редактирования html в виде текста, он будет отображать
    // код html (теги и их содержимое)
    private JEditorPane plainTextPane = new JEditorPane();

    private UndoManager undoManager = new UndoManager();

    private UndoListener undoListener = new UndoListener(undoManager);

    public View() {
        try {
            UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
        } catch (Exception e) {
            ExceptionHandler.log(e);
        }
    }

    public UndoListener getUndoListener() {
        return undoListener;
    }

    public Controller getController() {
        return controller;
    }

    public void setController(Controller controller) {
        this.controller = controller;
    }

    public void init(){
        initGui();
        FrameListener frameListener = new FrameListener(this);
        this.addWindowListener(frameListener);
        setVisible(true);
    }

    public void initMenuBar(){
        JMenuBar jMenuBar = new JMenuBar();
        MenuHelper.initFileMenu(this, jMenuBar);
        MenuHelper.initEditMenu(this, jMenuBar);
        MenuHelper.initStyleMenu(this, jMenuBar);
        MenuHelper.initAlignMenu(this, jMenuBar);
        MenuHelper.initColorMenu(this, jMenuBar);
        MenuHelper.initFontMenu(this, jMenuBar);
        MenuHelper.initHelpMenu(this, jMenuBar);
        this.getContentPane().add(jMenuBar, BorderLayout.NORTH);
    }

    public void initEditor(){
        htmlTextPane.setContentType("text/html");
        JScrollPane jScrollPane = new JScrollPane(htmlTextPane);
        tabbedPane.addTab("HTML", jScrollPane);
        JScrollPane pane = new JScrollPane(plainTextPane);
        tabbedPane.addTab("Текст", pane);
        tabbedPane.setPreferredSize(new Dimension(200, 300));
        TabbedPaneChangeListener tabbedPaneChangeListener = new TabbedPaneChangeListener(this);
        tabbedPane.addChangeListener(tabbedPaneChangeListener);
        this.getContentPane().add(tabbedPane, BorderLayout.CENTER);

    }

    public void initGui(){
        initMenuBar();
        initEditor();
        pack();
    }

    public void exit(){
        controller.exit();
    }

    //будет вызваться при выборе пунктов меню,
    // у которых наше представление указано в виде слушателя событий
    @Override
    public void actionPerformed(ActionEvent e) {
        switch (e.getActionCommand()){
            case "Новый":
                controller.createNewDocument();
                break;
            case "Открыть":
                controller.openDocument();
                break;
            case "Сохранить":
                controller.saveDocument();
                break;
            case "Сохранить как...":
                controller.saveDocumentAs();
                break;
            case "Выход":
                exit();
                break;
            case "О программе":
                showAbout();
                break;
        }

    }

    public void selectedTabChanged() {
        if(tabbedPane.getSelectedIndex() == 0){
            controller.setPlainText(plainTextPane.getText());
        }
        else if(tabbedPane.getSelectedIndex() == 1) {
            plainTextPane.setText(controller.getPlainText());
        }
        resetUndo();
    }

    public void undo(){
        try{
            undoManager.undo();
        }catch (Exception e){
            ExceptionHandler.log(e);
        }

    }

    public void redo(){
        try{
            undoManager.redo();
        }catch (Exception e){
            ExceptionHandler.log(e);
        }
    }

    public boolean canUndo(){
        return undoManager.canUndo();
    }

    public boolean canRedo(){
        return undoManager.canRedo();
    }

    public void resetUndo(){
        undoManager.discardAllEdits();
    }

    //возвращат true, если выбрана вкладка, отображающая html в панели вкладок
    public boolean isHtmlTabSelected(){
        return tabbedPane.getSelectedIndex() == 0;
    }

    //выбирает вкладку HTML и сбрасывает все изменения
    public void selectHtmlTab(){
        tabbedPane.setSelectedIndex(0);
        resetUndo();
    }

    //получает документ у контроллера и устанавливает его в панель редактирования htmlTextPane
    public void update(){
        htmlTextPane.setDocument(controller.getDocument());
    }

    //показывает диалоговое окно с информацией о программе
    public void showAbout(){
        JOptionPane.showMessageDialog(
                this, "О программе", "О программе", JOptionPane.INFORMATION_MESSAGE);
    }
}
