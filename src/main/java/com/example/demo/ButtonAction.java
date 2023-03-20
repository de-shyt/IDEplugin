package com.example.demo;

import com.intellij.ide.BrowserUtil;
import com.intellij.openapi.actionSystem.AnAction;
import com.intellij.openapi.actionSystem.AnActionEvent;
import com.intellij.openapi.project.Project;
import com.intellij.openapi.ui.Messages;
import org.jetbrains.annotations.NotNull;

public class ButtonAction extends AnAction {

  @Override
  public void actionPerformed(@NotNull AnActionEvent e) {
    String[] urlNames = {"Yandex", "Google"};
    String[] urls = {"https://yandex.com/", "https://www.google.com/"};
    int index = Messages.showDialog(
        "<html><body>" +
            "<p>Choose a search system you prefer:</p>" +
            "</body></html>",
        "Button Action",
        urlNames,
        0,
        Messages.getInformationIcon()
    );
    switch (index) {
      case 0:
        BrowserUtil.browse(urls[0]);
      case 1:
        BrowserUtil.browse(urls[1]);
    }
  }

  @Override
  public void update(@NotNull AnActionEvent event) {
    // Set the availability based on whether a project is open
    Project currentProject = event.getProject();
    event.getPresentation().setEnabledAndVisible(currentProject != null);
  }
}